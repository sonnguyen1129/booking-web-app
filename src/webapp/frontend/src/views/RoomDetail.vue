<template>
  <div class="content" v-loading="isLoading">
    <el-form ref="form" :model="roomDto" label-width="8rem">

      <el-form-item label="Floor">
        <el-row>
          <el-col :span="6">
            <el-input v-model="roomDto.floor" readonly></el-input>
          </el-col>
        </el-row>
      </el-form-item>

      <el-form-item label="Room name">
        <el-row>
          <el-col :span="6">
            <el-input v-model="roomDto.name" readonly></el-input>
          </el-col>
        </el-row>
      </el-form-item>

      <el-form-item label="Persons number">
        <el-row>
          <el-col :span="6">
            <el-input v-model="roomDto.personNumber" readonly></el-input>
          </el-col>
        </el-row>
      </el-form-item>

      <el-form-item label="Date">
        <el-row>
          <el-col :span="6">
            <el-date-picker
              placeholder=""
              v-model="roomBookingDto.date"
              type="date"
              :clearable = "false"
               format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"
              :picker-options="pickerOptions"
              @change="onChangeDate">
            </el-date-picker>
          </el-col>
        </el-row>
      </el-form-item>

      <el-form-item label="Time available">
         <el-row>
          <el-col :span="6">
            <el-select v-model="roomBookingDto.time" placeholder="">
              <el-option
                v-for="item in bookingTime"
                :key="item.value"
                :label="item.label"
                :value="item.value"
                :disabled="item.disabled">
              </el-option>
            </el-select>
          </el-col>
         </el-row>
      </el-form-item>

      <el-form-item label="Room features">
        <el-row>
          <el-col>
            <img v-if="roomDto.roomFeatures > 0" class="icon-png" src="@/assets/monitor.png"/>
            <img v-if="roomDto.roomFeatures > 1" class="icon-png" src="@/assets/micro.png"/>
            <img v-if="roomDto.roomFeatures > 2" class="icon-png" src="@/assets/projector.png"/>
          </el-col>
        </el-row>
      </el-form-item>

      <el-form-item label="Comment">
        <el-row>
          <el-col :span="6">
            <el-input v-model="roomBookingDto.comment" type="textarea" resize="none"></el-input>
          </el-col>
        </el-row>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onClickBooking">Book</el-button>
        <el-button @click="backWindow">Cancel</el-button>
      </el-form-item>
    </el-form>

    <!-- dialog -->
    <el-dialog
      title="Confirm box"
      :visible.sync="dialogVisible"
      width="30%">
      <ConfirmDialog :textConfirm="textConfirm" @cancel="cancel" @confirm="confirm" />
    </el-dialog>

  </div>
</template>

<script lang="ts">
/* eslint-disable */
import {  Component,  Vue, Prop} from 'vue-property-decorator'

import { roomService } from '@/services/room-service'
import { roomBookingService } from '@/services/room-booking-service'

import {  UserDto, RoomDto, RoomBookingDto } from '@/models'
import BookingTime from '@/commons/BookingTime.ts'

import ConfirmDialog from '@/views/dialog/ConfirmDialog.vue'
import moment from 'moment';

@Component({
  components: {
    ConfirmDialog
  }
})
export default class RoomDetail extends Vue {
  @Prop() id?: string;

  private userId: string = '';
  private roomDto: RoomDto = new RoomDto();
  private roomBookingDto: RoomBookingDto = new RoomBookingDto();
  private bookingTime: any = '';

  private isLoading: boolean = false;
  private dialogVisible: boolean = false;
  private textConfirm: string = '';
  private pickerOptions: any = '';

  private defaultDto() {
    this.$set(this.roomBookingDto, 'roomId', '');
    this.$set(this.roomBookingDto, 'userId', '');
    this.$set(this.roomBookingDto, 'date', moment().format('YYYY-MM-DD'));
    this.$set(this.roomBookingDto, 'time', '');
    this.$set(this.roomBookingDto, 'comment', '');
  }

  private mounted() {
    this.isLoading = true;
    this.defaultDto();
    this.getRoomInfo()
    .then(() => {
      this.getTimeCanBook();
    })
    .finally(() => {
      this.isLoading = false;
    })

    // disabled time in past
    this.pickerOptions = {
      disabledDate(time: any) {
         return time.getTime() < Date.now() - 8.64e7;
      }
    }

      let temp: any = localStorage.getItem('userId') ? localStorage.getItem('userId') : '';
      this.userId = temp;
  }

  private getRoomInfo(): Promise<any> {
    return new Promise((resolve, reject) => {
      if (this.id) {
        roomService.getRoomById(this.id)
        .then((res: any) => {
          this.$set(this.roomDto, 'id', res.data.id);
          this.$set(this.roomDto, 'floor', res.data.floor);
          this.$set(this.roomDto, 'name', res.data.name);
          this.$set(this.roomDto, 'personNumber', res.data.personNumber);
          this.$set(this.roomDto, 'roomFeatures', res.data.roomFeatures);
          this.$set(this.roomDto, 'img', res.data.img);
        })
        .finally(() => resolve(true));
      }
    })
    
  }

  private getTimeCanBook(): Promise<any> {
    return new Promise((resolve, reject) => {
      if (this.id && this.roomBookingDto.date) {
        roomBookingService.getListTimeBooked(this.id, this.roomBookingDto.date)
        .then((res: any) => {
          let bookedTime: any = res.data;
          let listBookingTime: any = new BookingTime().bookingTime;
          if (bookedTime.length > 0) {
            for(let temp = 0; temp < bookedTime.length; temp ++) {
              this.$set(listBookingTime[bookedTime[temp]], 'disabled', true);
            }
          }
          this.bookingTime = listBookingTime;
        })
        .finally(() => resolve(true));
      }
    })
  }

  private onChangeDate() {
    this.getTimeCanBook();
  }

  // private getTimeCanBook() {
  //   let listBookingTime: any = BookingTime.bookingTime;
  //   if (this.bookedTime.length > 0) {
  //       for(let temp = -1; temp ++; temp < this.bookedTime.length) {
  //         this.$set(listBookingTime[this.bookedTime[temp]], 'disabled', true);
  //       }
  //   }
  //   this.bookingTime = listBookingTime;
  // }

  private onClickBooking() {
    this.textConfirm = 'Do you wish to book this room?';
    this.dialogVisible = true;
  }

  private backWindow() {
    window.history.back();
  }

  private cancel() {
    this.dialogVisible = false;
  }

  private confirm() {
    this.dialogVisible = false;
    this.$set(this.roomBookingDto, 'roomId', this.roomDto.id);
    this.$set(this.roomBookingDto, 'userId', this.userId);
    roomBookingService.insertBookingTime(this.roomBookingDto)
    .then((res: any) => {
      this.showSuccessMsg();
    })
    .catch((err: any) => {
      console.log(err);
    })
  }

   private showSuccessMsg() {
    this.$notify({
      title: 'Success',
      message: 'Booking success',
      type: 'success'
    });
  }

}
</script>

<style lang="scss" scoped>
  .icon-png {
    width: 2rem;
    margin-right: 1rem;
  }
</style>
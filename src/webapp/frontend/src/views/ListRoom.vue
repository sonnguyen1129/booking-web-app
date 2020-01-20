<template>
  <div class="content" v-loading="isLoading">
    <h1>List room</h1>
    <div class="list-img">
      <el-row>
        <el-col class="content" :lg="4" :xs="24" v-for="room in listRoom" :key="room.id">

          <el-popover
            placement="bottom"
            title="Title"
            width="320"
            trigger="hover">
            <span>This is content</span>
            <img slot="reference" :src="require(`@/assets/${room.img}`)" />
          </el-popover>
          <span>{{room.name}}</span>
          <br>
          <el-button  type="success" round @click="seeDetail(room.id)">Booking this room</el-button>

        </el-col>
      </el-row>

    </div>

  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { roomService } from '@/services/room-service'

@Component({
  components: {
  }
})
/* eslint-disable */
export default class ListRoom extends Vue {
  private isLoading: boolean = false;
  private listRoom: any = '';
  
  private mounted() {
    this.isLoading = true;
    roomService.getAllRoom()
    .then((res: any) => {
      if (res.status === 200) {
        this.listRoom = res.data;
      }
    })
    .catch((err: any) => {
      console.log(err);
    })
    .finally(() => {
      this.isLoading = false;
    });

    // roomService.getRoomById('1')
    // .then((res: any) => {
    //   console.log(res)
    // })
    // .catch((err: any) => {
    //   console.log(err);
    // })
  }

  private seeDetail(id: string) {
    this.$router.push( {
      name: 'room-detail',
      query: {
        'id' : id
      }
      } );
  }

}
</script>

<style lang="scss" scoped>
  img {
    width: 100%;
    padding: 5%;

    &:hover {
      opacity: 0.7;
    }
  }
  .content {
  position: relative;
  text-align: center;
  color: green;
}

</style>

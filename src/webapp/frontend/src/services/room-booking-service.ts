/* eslint-disable */
import Vue from 'vue';
import { AxiosPromise } from 'axios';
import authHeader from './auth-header';
import { RoomBookingDto } from '@/models';

class RoomBookingService extends Vue {
  private ROOT_API = 'http://localhost:8090/room-booking';  // Root api 

  public getListTimeBooked(roomId: string, date: string): AxiosPromise<any> {
    return Vue.axios.get<any>(this.ROOT_API + '/time/' + roomId + '/' + date, { headers: authHeader()});
  }

  public insertBookingTime(roomBooking: RoomBookingDto): AxiosPromise<RoomBookingDto> {
    return Vue.axios.post<RoomBookingDto>(this.ROOT_API + '/insert', roomBooking, { headers: authHeader()});
  }

}
export const roomBookingService = new RoomBookingService();
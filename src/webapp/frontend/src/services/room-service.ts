/* eslint-disable */
import Vue from 'vue';
import { AxiosPromise } from 'axios';
import authHeader from './auth-header';
import { RoomBookingDto } from '@/models';

class RoomService extends Vue {
  private ROOT_API = 'http://localhost:8090/room';  // Root api 

  public getAllRoom(): AxiosPromise<any> {
    return Vue.axios.get<any>(this.ROOT_API + '/get/all', { headers: authHeader()});
  }

  public getRoomById(id: string): AxiosPromise<any> {
    return Vue.axios.get<any>(this.ROOT_API + '/get/' + id, { headers: authHeader()});
  }

}
export const roomService = new RoomService();
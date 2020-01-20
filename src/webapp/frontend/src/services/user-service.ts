/* eslint-disable */
import Vue from 'vue';
import { AxiosPromise } from 'axios';
import authHeader from './auth-header';

class UserService extends Vue {
  private ROOT_API = 'http://localhost:8090/user';  // Root api 

  public getHello(): AxiosPromise<String> {
    return Vue.axios.get<String>(this.ROOT_API + '/hello', {headers: authHeader()});
  }

  public getUserById(userid: string): AxiosPromise<String> {
    return Vue.axios.get<String>(this.ROOT_API + '/current-user/' + userid , {headers: authHeader()});
  }

}
export const userService = new UserService();
/* eslint-disable */
import Vue from 'vue';
import { AxiosPromise } from 'axios';
import { UserDto } from '@/models/UserDto';  // @ là ký tự để trỏ đến root path (folder src)
import EventBus from '@/EventBus';

class AuthService extends Vue {
  private URL_API = 'http://localhost:8090';  // Root api 

  public login(userDto: UserDto): AxiosPromise<UserDto> {
    return Vue.axios.post<UserDto>(this.URL_API + '/login', userDto)
    .then((res: any) => {
      // console.log(res)
      if (res.status === 200) {
        localStorage.setItem('auth', JSON.stringify(res.data));
        EventBus.$emit('logged', 'User logged');
      }
      return res;
    })
  }

  public logout() {
    localStorage.removeItem('auth');
    EventBus.$emit('logout', 'User log out');
  }

  public register(userDto: UserDto): AxiosPromise<UserDto> {
    return Vue.axios.post<UserDto>(this.URL_API + '/register', userDto)
  }
}
export const authService = new AuthService();
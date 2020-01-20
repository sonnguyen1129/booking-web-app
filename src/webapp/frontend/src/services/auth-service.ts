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
        localStorage.setItem('token', JSON.stringify(res.data.token));
        localStorage.setItem('userId', JSON.stringify(res.data.id));
        localStorage.setItem('role', JSON.stringify(res.data.role));
        EventBus.$emit('logged', 'User logged');
      }
      return res;
    })
  }

  public logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('userId');
    localStorage.removeItem('role');
    EventBus.$emit('logout', 'User log out');
  }

  public register(userDto: UserDto): AxiosPromise<UserDto> {
    return Vue.axios.post<UserDto>(this.URL_API + '/register', userDto)
  }
}
export const authService = new AuthService();
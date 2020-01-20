<template>
  <div class="content">
    <b-row>
      <b-col offset="4" xl="4">
        <b-form @submit.prevent="onSubmit" @reset="onReset">
          <b-form-group
            label="Username:"
            label-cols-xl="2">
            <b-form-input
              v-model="userInput.username"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group
            label="Password:"
            label-cols-xl="2">
            <b-form-input
              v-model="userInput.password"
              required
              type="password"
            ></b-form-input>
          </b-form-group>
          <span v-if="loginFailMsg" style="color:red">Invalid username or password</span>
          <br>
          <b-button type="submit" variant="primary">Submit</b-button>
          <b-button type="reset" variant="danger">Reset</b-button>
        </b-form>
      </b-col>
    </b-row>
  </div>
</template>

<style lang="scss" scoped>

</style>

<script lang="ts">
/* eslint-disable */
import { Component, Vue } from 'vue-property-decorator'
import { UserDto } from '@/models/UserDto.ts';
import { authService } from '@/services/auth-service.ts'
import { userService } from '@/services/user-service.ts'
import { AxiosResponse, AxiosPromise } from 'axios';

@Component({
  components: {
  }
})
export default class Login extends Vue {
    private userInput: UserDto = new UserDto();
    private loginFailMsg: boolean = false;
    private isAdmin: boolean = false;

    private mounted() {
      
    }

    private onSubmit() {
      authService.login(this.userInput)
      .then((res: any) => {
        if (res.status === 200) {
          this.loginFailMsg = false;
          this.redirectPage();
        }
      })
      .catch((error: any) => {
        this.loginFailMsg = true;
      })
    }

    private redirectPage() {
      this.getCurrentUser()
      .then(() => {
        if (this.isAdmin) {
          this.$router.push('admin-home');
        }
        else {
          this.$router.push('home');
        }
      })
      
    }

    private getCurrentUser(): Promise<any> {
      return new Promise((resolve, reject) => {
        let temp: any = localStorage.getItem('userId') ? localStorage.getItem('userId') : '';
        userService.getUserById(temp)
        .then((res: any) => {
          if (res.data.role === 'USER') {
            this.isAdmin = false;
          }
          else {
            this.isAdmin = true;
          }
        })
        .finally(() => resolve(true))
      })
    }

    private onReset() {
      this.loginFailMsg = false;
    }

}
</script>
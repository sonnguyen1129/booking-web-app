<template>
  <div>
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
import { Component, Vue } from "vue-property-decorator";
import { UserDto } from "@/models/UserDto.ts";
import { authService } from "@/services/auth-service.ts";
import { AxiosResponse } from "axios";

@Component({
  components: {
  }
})
export default class Login extends Vue {
    private userInput: UserDto = new UserDto();
    private checkLogin: boolean = false;
    private loginFailMsg: boolean = false;

    private mounted() {
      
    }

    private onSubmit() {
      authService.login(this.userInput)
      .then((res: any) => {
        if (res.status === 200) {
          this.checkLogin = true;
        }
        this.redirectPage();
      })
      .catch((error: any) => {
        this.checkLogin = false;
        this.loginFailMsg = true;
      })
    }

    private redirectPage() {
      if (this.checkLogin) {
        this.$router.push('home');
        this.loginFailMsg = false;
      }
    }

    private onReset() {
      this.loginFailMsg = false;
    }

}
</script>
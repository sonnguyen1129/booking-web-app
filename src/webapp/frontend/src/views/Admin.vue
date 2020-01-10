<template>
<div>
  Admin Page
  <a href="#" @click="logout">Log out</a>
  {{token}}
</div>
</template>

<style lang="scss" scoped>

</style>

<script lang="ts">
/* eslint-disable */
import {  Component,  Vue} from "vue-property-decorator";
import {  UserDto } from "@/models/UserDto.ts";
import {  userService } from "@/services/user-service.ts";
import {  authService } from "@/services/auth-service.ts";
import {  AxiosResponse } from "axios";

@Component({
  components: {}
})
export default class Admin extends Vue {
  private user: UserDto = new UserDto();
  private token: any = '';

  private text: string = '';

  private mounted() {
    // userService.getCurrentUser()
    //   .then((res: any) => {
    //     console.log(res);
    //   })
    //   .catch((err: any) => {
    //     console.log(err);
    //   })

    this.token = localStorage.getItem('user');

    userService.getHello()
    .then((res: any) => {
      console.log(res);
    })
    .catch((err: any) => {
    })
  }

  private logout() {
    authService.logout();

    this.$router.push({
      name: 'login'
    });
  }

}
</script>

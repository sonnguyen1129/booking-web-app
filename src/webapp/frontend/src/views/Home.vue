<template>
<div class="content" v-loading="isLoading">
  Home
</div>
</template>

<style lang="scss" scoped>

</style>

<script lang="ts">
/* eslint-disable */
import {  Component,  Vue} from 'vue-property-decorator';

import {  UserDto } from '@/models/UserDto.ts';

import {  userService } from '@/services/user-service.ts';
import {  authService } from '@/services/auth-service.ts';
import authRole from '@/services/auth-role.ts';

import {  AxiosResponse } from 'axios';

@Component({
  components: {}
})
export default class HomeAdmin extends Vue {
  private user: UserDto = new UserDto();
  private token: any = '';
  private isLoading: boolean = false;

  private text: string = '';

  private mounted() {
    this.isLoading = true;
    this.checkLogged();
    if (authRole() === 'USER') {
      this.isLoading = false;
    }
  }

  private checkLogged() {
    if (!localStorage.getItem('token') && !localStorage.getItem('userId')) {
      this.$router.push( {name: 'login'});
    }
  }

}
</script>

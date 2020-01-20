<template>
<div class="content">
  Home admin
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
import {  AxiosResponse } from 'axios';

@Component({
  components: {}
})
export default class Home extends Vue {
  private user: UserDto = new UserDto();
  private token: any = '';

  private text: string = '';

  private mounted() {
    if (!localStorage.getItem('token') && !localStorage.getItem('userId')) {
      this.$router.push( {name: 'login'} );
    }
  }

}
</script>

<template>
<div>
  Profile
  <span>Name : {{user.username}}</span>

</div>
</template>

<style lang="scss" scoped>

</style>

<script lang="ts">
/* eslint-disable */
import {  Component,  Vue} from 'vue-property-decorator';
import {  UserDto } from '@/models/UserDto.ts';
import {  userService } from '@/services/user-service.ts';
import {  AxiosResponse } from 'axios';

@Component({
  components: {}
})
export default class Profile extends Vue {
  private user: UserDto = new UserDto();
  private token: any = '';

  private text: string = '';

  private mounted() {
    this.getCurrentUser();

  }

  private getCurrentUser() {
    let json: any = localStorage.getItem('auth') ? localStorage.getItem('auth') : '';
    let info: any | null = JSON.parse(json);
    if (info) {
      this.$set(this.user, 'username', info.username);
    }
  }


}
</script>

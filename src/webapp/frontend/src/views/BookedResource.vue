<template>
<div class="content">
  <h2>Profile</h2>
  <span>Name : {{user.username}}</span>
  <br>
  <span>Phone : {{user.phone}}</span>
  <br>
  <span>Role : {{user.role}}</span>

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
export default class BookedResource extends Vue {
  private user: UserDto = new UserDto();
  private token: any = '';

  private text: string = '';

  private mounted() {
    this.getCurrentUser();
  }

  private getCurrentUser() {
      let temp: any = localStorage.getItem('userId') ? localStorage.getItem('userId') : '';
      userService.getUserById(temp)
      .then((res: any) => {
        this.$set(this.user, 'username', res.data.username);
        this.$set(this.user, 'phone', res.data.phone);
        this.$set(this.user, 'role', res.data.role);
      })
  }


}
</script>

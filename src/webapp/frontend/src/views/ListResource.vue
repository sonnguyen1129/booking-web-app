<template>
  <div class="content">
    <h2>S</h2>
  </div>
</template>

<style lang="scss" scoped>
</style>

<script lang="ts">
/* eslint-disable */
import { Component, Vue } from "vue-property-decorator";
import { UserDto } from "@/models/UserDto.ts";
import { userService } from "@/services/user-service.ts";
import { AxiosResponse } from "axios";

@Component({
  components: {}
})
export default class ListResource extends Vue {
  private user: UserDto = new UserDto();
  private token: any = "";

  private text: string = "";

  private mounted() {}
}
</script>

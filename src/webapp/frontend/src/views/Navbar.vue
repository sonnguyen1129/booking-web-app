<template>
  <div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand to="/">Booking App</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav v-if="isLogged">
        <b-nav-item to="list-room">Room</b-nav-item>
        <b-nav-item to="list-resource">List 1</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">

        <b-nav-item-dropdown text="Lang" right>
          <b-dropdown-item href="#">EN</b-dropdown-item>
          <b-dropdown-item href="#">JP</b-dropdown-item>
        </b-nav-item-dropdown>

        <b-nav-item-dropdown right v-if="isLogged">
          <!-- Using 'button-content' slot -->
          <template v-slot:button-content>
            <em>{{currentUser.username}}</em>
          </template>
          <b-dropdown-item to="/profile">Profile</b-dropdown-item>
          <b-dropdown-item to="/booked-resource">Booked Resource</b-dropdown-item>
          <b-dropdown-item @click="logout">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script lang="ts">
/* eslint-disable*/
import { Component, Vue } from 'vue-property-decorator'
import { UserDto } from '@/models/UserDto.ts'
import { authService} from '@/services/auth-service.ts'
import { userService } from '@/services/user-service'
import EventBus from '@/EventBus'

@Component({
  components: {
  }
})
/* eslint-disable */
export default class Navbar extends Vue {
  private isLogged: boolean = false;

  private currentUser: UserDto = new UserDto();

  private created() {

    if (localStorage.getItem('token') && localStorage.getItem('userId')) {
      this.getCurrentUser();
    }

    EventBus.$on('logged', () => {
      this.getCurrentUser();
    })

    EventBus.$on('logout', () => {
      this.isLogged = false;
    })

  }

  private getCurrentUser() {
      let temp: any = localStorage.getItem('userId') ? localStorage.getItem('userId') : '';
      userService.getUserById(temp)
      .then((res: any) => {
        this.isLogged = true;
        this.$set(this.currentUser, 'username', res.data.username);
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

<style lang="scss" scoped>
.router-link-exact-active {
  font-weight: bold;
}
.navbar-dark {
  .navbar-nav {
    .nav-link {
      color: white;
      font-size: 20px;
    }
  }

}
</style>

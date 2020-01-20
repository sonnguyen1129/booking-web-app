<template>
  <div id="app">
    <Navbar/>
    <router-view />
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import Navbar from '@/views/Navbar.vue'

@Component({
  components: {
    Navbar
  }
})
/* eslint-disable */
export default class App extends Vue {
  private isLogined: boolean = false;
  private created() {
    if (localStorage.getItem('token') && localStorage.getItem('userId')) {
      this.isLogined = true;
    }
  }
  private mounted () {
    
  }
}
</script>

<style>
 @import url('styles/style.scss');
</style>

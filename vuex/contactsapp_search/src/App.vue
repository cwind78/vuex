<template>
  <div>
    <menus></menus>
    <router-view></router-view>
    <loading v-show="isloading"></loading>
    <notifications group="common" />
  </div>
</template>

<script>
import Menus from './components/Menus.vue'
import Loading from './components/Loading.vue'
import { mapState } from "vuex"

export default {
  name: 'App',
  components: {Menus, Loading},
  computed: {
    ...mapState(["isloading"])
  }
}
</script>

<style>
/*@import 'vue-awesome-notifications/dist/styles/style.css';*/

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.error {
  color:red;
}
</style>

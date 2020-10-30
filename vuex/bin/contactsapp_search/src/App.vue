<template>
  <div id="app">
    <div v-show="!getAuth">
      <!--button type="button" class="btn btn-default" @click="updateIsMenu()">
        <span class="glyphicon glyphicon-menu-hamburger" aria-hidden="true"></span>
      </button-->
      <font-awesome-icon icon="bars" @click="updateIsMenu()"></font-awesome-icon>
    </div>
    <menus v-show="isMenu"></menus>
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
    ...mapState(["isloading", "isMenu"]),
    getAuth: function() {
      let auth = this.$store.state.auth.auth;
      console.log(auth);
      return auth == [] || auth.length == 0
    },
  },
  methods: {
    updateIsMenu: function() {
      console.log("isMenu="+this.isMenu)
      this.$store.commit("changeMenu", {isMenu: !this.isMenu})
    }
  }
}
</script>

<style>
/*@import 'vue-awesome-notifications/dist/styles/style.css';*/

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
.error {
  color:red;
}

</style>

<template>
  <div id="menu" v-if="!getAuth" class="modal col-xs-12">
    <div class="col-sm-4 col-xs-12">
      <div class="col-xs-12 text-right">
          <span data-toggle="tooltip" title="Log out">
            <font-awesome-icon icon="sign-out-alt" class="pull-right" @click.stop="logout"></font-awesome-icon>
          </span>
          <span data-toggle="tooltip" title="Dismiss menu">
            <font-awesome-icon icon="arrow-left" class="pull-right" @click.stop="dismissme"></font-awesome-icon>
          </span>
          <!--a @click.stop="dismissme" class="pull-right"><=</a-->
        </span>
      </div>
      <!--router-link v-else :to="{name : 'Login'}">Login</router-link-->
      <div class="" v-for="(menu, index) in menus">
        <div v-if="menu.deep=='0'&&index>0" :style="{border:'1px dotted grey'}">
        </div>
        <div class="" @click="goMenu(menu)" :style="getPaddingLeft(menu)">{{menu.menu_name}}</div>
        <!--router-link :to="{name : 'HelloWorld'}">Home</router-link>
        <router-link :to="{name : 'Contact'}">Contact</router-link-->
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import Constant from '../constant'
import { mapState } from "vuex"
import Vue from 'vue'

export default {
  name: 'menus',
  data: function() {
    return {
      menus: []
    }
  },
  created: function() {
    $('[data-toggle="tooltip"]').tooltip();
    this.getMenuList();
  },
  computed: {
  	getAuth : function() {
  	  let auth = this.$store.state.auth.auth;
  	  return auth == [] || auth.length == 0
  	}
  },
  methods: {
  	logout : function() {
  	  this.$store.dispatch("auth/dismissAuth", {auth:[]})
  	},
    getMenuList: function() {
      var vm = this
      axios.get(Constant.BASE_URL + "menu", {params: {menu_id:null}})
        .then((response) => {
          vm.menus = response.data
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    goMenu: function(menu) {
      console.log("url="+menu.url)
      if (menu.url != null) {
        var router_name = menu.url.split("/")[menu.url.split("/").length-1]
        this.$router.addRoutes([{path: menu.url, name: router_name, component: () => import('./' +menu.path+'.vue')}])
        this.$router.push({name: router_name});
        this.$store.commit("changeMenu", {isMenu: false})
      }
    },
    getPaddingLeft: function(menu) {
      return {paddingLeft: String(parseInt(menu.deep)*20)+"px"}
    },
    dismissme : function() {
      this.$store.commit("changeMenu", {isMenu: false})
    }
  },
  watch: {
    getAuth: function(val) {
      if (!val) {
        this.getMenuList()
      }
    }
  }
}
</script>

<style scoped>
  #menu {
    position: absolute;
    background-color: white;
    padding: 0px 30px 20px 5px;
    opacity: 0.8;
    filter: alpha(opacity=80);
  }

  .modal {
    display: block; position: fixed; z-index: 1;
    left: 0; top: 0; width: 100%; height: 100%;
    overflow: auto;
    background-color: grey;/*rgba(0, 0, 0, 0, 4);*/
    opacity: 0.2;
  }
</style>

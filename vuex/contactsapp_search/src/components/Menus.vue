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
    $('[data-toggle="tooltip"]').tooltip()
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
      axios.get(Constant.BASE_URL + "menu")
        .then((response) => {
          vm.menus = response.data
          var route_name = null;
          var route_component = null;
          //var components = [];
          //var index = 0;
          for (var i in vm.menus) {
            if (vm.menus[i].url != null) {
              route_name = vm.menus[i].url.split("/")[vm.menus[i].url.split("/").length-1]
              console.log("name="+route_name)
              //route_component = () => import("./"+vm.menus[i].path)
              //component = System.import('./' + vm.menus[i].path+".vue")
              const route_component = resolve => require(['./'+vm.menus[i].path+'.vue'], m => resolve(m.default));
              vm.$router.addRoutes([{path: vm.menus[i].url, name: route_name, component: route_component}])
              //vm.$router.addRoutes([{path: vm.menus[i].url, name: route_name, component: route_component}])
              //vm.$router.options.routes.push({path: vm.menus[i].url, name: route_name, component: () => import('./' + vm.menus[i].path+".vue")})
              /*Vue.component(route_name, () => {
                route_component = import('./'+vm.menus[i].path+'.vue')
                vm.$router.addRoutes([{path: vm.menus[i].url, name: route_name, component: route_component}])
              })*/
              //components[index] = () => import('./' + vm.menus[i].path+".vue")
              //index++
            }
          }

          /*index = 0
          for (var i in vm.menus) {
            if (vm.menus[i].url != null) {
              route_name = vm.menus[i].url.split("/")[vm.menus[i].url.split("/").length-1]
              vm.$router.addRoutes([{path: vm.menus[i].url, name: route_name, component: components[index]}])
              index++
            }
          }*/

          //vm.$router.reload()
          //m.$forceUpdate()
          //console.log(JSON.stringify(vm.$router.options.routes))

          /*if (temp.length > 0) {
            console.log(temp);
            vm.$router.addRoutes(temp);

            setTimeout(function() {
              vm.$router.options.routes.forEach(route => {
                console.log(route.component)
              })
            }, 5000)
          }*/
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    goMenu: function(menu) {
      console.log("url="+menu.url)
      if (menu.url != null) {
        this.$router.push({name: menu.url.split("/")[menu.url.split("/").length-1]});
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

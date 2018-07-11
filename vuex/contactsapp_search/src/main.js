// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from '@/store/index'
import ES6Promise from 'es6-promise'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import VueAWN from "vue-awesome-notifications"


ES6Promise.polyfill();
Vue.config.productionTip = false
Vue.use(VueAWN, {position:"top"})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>'
})

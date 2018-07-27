// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from '@/store/index'
import ES6Promise from 'es6-promise'
// import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import { library } from '@fortawesome/fontawesome-svg-core'
// import { faCoffee } from '@fortawesome/free-solid-svg-icons'
import { faBars } from '@fortawesome/free-solid-svg-icons'
import { faSignOutAlt } from '@fortawesome/free-solid-svg-icons'
import { faArrowLeft } from '@fortawesome/free-solid-svg-icons'
import { faSearch } from '@fortawesome/free-solid-svg-icons'
import { faIdBadge } from '@fortawesome/free-solid-svg-icons'
import { faUnlockAlt } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

/*import VueAWN from "vue-awesome-notifications"*/
import Notifications from 'vue-notification'
import VeeValidate from 'vee-validate'
import CommonMethod from './plugin/commonplugin'

ES6Promise.polyfill()
library.add(faBars)
library.add(faSignOutAlt)
library.add(faArrowLeft)
library.add(faSearch)
library.add(faIdBadge)
library.add(faUnlockAlt)

Vue.component('font-awesome-icon', FontAwesomeIcon)
Vue.config.productionTip = false
/*Vue.use(VueAWN, {position:"top"})*/
Vue.use(Notifications)
Vue.use(VeeValidate);
Vue.use(CommonMethod);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
  components: { App },
  template: '<App/>'
})

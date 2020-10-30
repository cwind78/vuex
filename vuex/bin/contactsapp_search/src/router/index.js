import Vue from 'vue'
import axios from 'axios'
import Router from 'vue-router'
import store from '../store'
import Login from '@/components/Login'
import Contact from '@/components/contact/Contact'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

const checkAuth = (to, from, next) => {
  if (store.state.auth.auth == [] || store.state.auth.auth.length == 0) {
    next({
      path: '/Login',
      query: { redirect: to.fullPath }
    })
  } else {
    return next()
  }
}

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    /*{
      path: '/contact',
      name: 'Contact',
      component: Contact
    },*/
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld,
      beforeEnter: checkAuth
    }
  ]
})

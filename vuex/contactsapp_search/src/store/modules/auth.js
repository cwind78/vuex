import Vue from 'vue'
import axios from 'axios'
import Constant from '../../constant'
import router from '../../router'

export default {
  namespaced: true,
  state: {
    auth: [],
    user: {},
    users: [],
    isPop: false,
    isID: false
  },
  getters: {
  },
  mutations: {
    updateAuth (state, payload) {
      state.auth = payload.auth;
    },
    updateUser (state, payload) {
      state.user = payload.user;
    },
    updateUsers (state, payload) {
      state.users = payload;
    },
    updateIsPop (state, payload) {
      state.isPop = payload.isPop;
    },
    updateIsID (state, payload) {
      state.isID = payload.isID;
    }
  },
  actions : {
    updateAuth (store, payload)  {
      store.commit("changeLoading", {isloading: true}, {root: true})
      axios.get(Constant.BASE_URL + "auth/"+payload.id+"/"+payload.pwd)
        .then((response) => {
          if (response.data == [] || response.data[0] == null) {
            Vue.prototype.$noti_warn('Inputed wrong id or password')
          } else {
            store.commit("updateAuth", { auth : response.data })
            router.push({name: "HelloWorld"})
          }
          store.commit("changeLoading", {isloading: false}, {root: true})
        })
        .catch(function (error) {
          store.commit("changeLoading", {isloading: false}, {root: true})
          Vue.prototype.noti_warn("Please notify me this error : "+error.response)
        })
    },
    dismissAuth (store, payload) {
      store.commit("updateAuth", payload)
      router.push({name: "Login"})
    },
    updateUser (store, payload)  {
      store.commit("changeLoading", {isloading: true}, {root: true})
      axios.post(Constant.BASE_URL + "user/", payload.user)
        .then((response) => {
          Vue.prototype.$noti_info("Completed to save")
          store.commit("changeLoading", {isloading: false}, {root: true})
        })
    },
    signUpUser (store, payload)  {
      store.commit("changeLoading", {isloading: true}, {root: true})
      axios.post(Constant.BASE_URL + "user/signup/", payload.user)
        .then((response) => {
          store.commit("updateIsPop", {isPop: false})
          store.commit("changeLoading", {isloading: false}, {root: true})
          Vue.prototype.$noti_succ('Thank your sign up')
        })
        .catch(function (error) {
          store.commit("changeLoading", {isloading: false}, {root: true})
          Vue.prototype.$noti_warn('Make sure you use a duplicate ID')
        })
    },
    checkID (store, payload) {
      store.commit("changeLoading", {isloading: true}, {root: true})
      axios.get(Constant.BASE_URL + "user/checkid/"+payload.id)
        .then((response) => {
          console.log(response.data);
          if (response.data[0] != null) {
            Vue.prototype.$noti_warn('Already exist ID! Please use other ID')
          } else {
            Vue.prototype.$noti_succ('You can this.id')

            store.commit("updateIsID", {isID: true})
          }
          store.commit("changeLoading", {isloading: false}, {root: true})
        })
        .catch(function (error) {
          store.commit("changeLoading", {isloading: false}, {root: true})
          Vue.prototype.noti_warn("Please notify me this error : "+error.response)
        })
    },
    getUserList (store, payload) {
      store.commit("changeLoading", {isloading: true}, {root: true})
      axios.get(Constant.BASE_URL + "user", {params: {name: payload.name}})
        .then((response) => {
          console.log(response.data);
          if (response.data[0] == null) {
            Vue.prototype.$noti_warn('Data is not exist')
          } else {
            store.commit("updateUsers", response.data)
          }
          store.commit("changeLoading", {isloading: false}, {root: true})
        })
        .catch(function (error) {
          store.commit("changeLoading", {isloading: false}, {root: true})
          console.log("Please notify me this error : "+error.response)
        })
    }
  }
}
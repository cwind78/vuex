import axios from 'axios';
import Constant from '../../constant';
import router from '../../router'

export default {
  namespaced: true,
  state: {
    auth: []
  },
  getters: {
  },
  mutations: {
    updateAuth (state, payload) {
      state.auth = payload.auth;
    }
  },
  actions : {
    updateAuth (store, payload)  {
      axios.get(Constant.BASE_URL + "auth/"+payload.id+"/"+payload.pwd)
        .then((response) => {
          store.commit("updateAuth", { auth : response.data })
          router.push({name: "HelloWorld"})
        })
    },
    dismissAuth (store, payload) {
      store.commit("updateAuth", payload)
      router.push({name: "Login"})
    }
  }
}
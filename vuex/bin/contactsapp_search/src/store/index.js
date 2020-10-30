import Vue from 'vue';
import Vuex from 'vuex';
//import Constant from '../constant';
//import SearchApi from '../api/SearchAPI';
import contact from './modules/contact';
import auth from './modules/auth';

Vue.use(Vuex);

/*const store = new Vuex.Store({
	state : {
		contacts : []
	},
	mutations : {
		[Constant.SEARCH_CONTACT] : (state, payload) => {
			state.contacts = payload.contacts;
		}
	},
	actions : {
		[Constant.SEARCH_CONTACT] : (store, payload) => {
			SearchApi.searchContact(payload.name)
				.then((response) => {
					store.commit(Constant.SEARCH_CONTACT, { contacts : response.data })
				})
		}
	}
})

export default store;*/
export default new Vuex.Store({
  modules: {
    contact,
    auth
  },

  state: { // = data
    isloading: false,
    isMenu: false,
  },

  getters: { // = computed properties

  },

  actions: { // = computed properties
    /*changeLoading: (store, payload) => {
    	store.commit(changeLoading, payload)
    }*/
  },

  mutations: {
    changeLoading: (state, payload) => {
    	state.isloading = payload.isloading
    },
    changeMenu: (state, payload) => {
      state.isMenu = payload.isMenu
    }
  }
})
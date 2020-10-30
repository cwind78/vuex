//import Constant from '../constant';
import SearchApi from '../../api/SearchAPI';

export default {
	namespaced : true,
	state : {
		contacts : []
	},
	getters : {

	},
	mutations : {
		searchContact (state, payload) {
			state.contacts = payload.contacts;
		}
	},
	actions : {
		searchContact (store, payload)  {
			store.commit("changeLoading", {isloading:true}, {root: true})
			SearchApi.searchContact(payload.name)
				.then((response) => {
					store.commit("searchContact", { contacts : response.data })
					store.commit("changeLoading", {isloading:false}, {root: true})
				})
		}
	}
}
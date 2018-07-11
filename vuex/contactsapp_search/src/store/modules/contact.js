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
			SearchApi.searchContact(payload.name)
				.then((response) => {
					store.commit("searchContact", { contacts : response.data })
				})
		}
	}
}
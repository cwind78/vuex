<template>
<div class="layer">
	<div>
		<div class="btn" @click="getNaverLoginPopupPage()">NAVER 로그인</div>
	</div>
	<naverLogin class="pop" v-show="isPop"></naverLogin>
</div>
</template>
<script>
import mapState from "vuex"
import naverLogin from "./NaverLogin.vue"

export default {
	name: "App",
	components: {naverLogin},
	data: function() {
		return {
			default_id: "cwind78",
			default_pwd: "0911choi"
		}
	},
	computed: {
		isPop: function() {
			return this.$store.state.auth.isPop;
		}
	},
	methods: {
		getNaverLoginPopupPage: function() {
			this.$store.commit("auth/updateIsPop", {isPop: true});
		}
	}
}
</script>
<style scoped>
.layer{
  position:absolute;
  top:0;right:0;bottom:0;left:0;
  display:-webkit-box;
  display:-moz-box;
  display:-ms-flexbox;
  display:-webkit-flex;
  display:flex;

  align-items:center;
  justify-content:center;
  -webkit-align-items:center;
  -webkit-justify-content:center;

  -webkit-box-pack:center;
  -webkit-box-align:center;
  -moz-box-pack:center;
  -moz-box-align:center;
  -ms-box-pack:center;
  -ms-box-align:center;

  background-color: grey;/*rgba(0, 0, 0, 0, 4);*/
  opacity: 0.5;
}

/*
.modal {
  display: block; position: fixed; z-index: 1;
  left: 0; top: 0; width: 100%; height: 100%;
  overflow: auto;
  background-color: grey;
  opacity: 0.2;
}
*/

.pop {
  position:absolute;
}
</style>
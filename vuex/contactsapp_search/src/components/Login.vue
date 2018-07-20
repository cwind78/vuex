<template>
  <div class="layer row">
    <div class="card col-sm-3 col-xs-12">
      <div class="title card-title">
        <h3>Login</h3>
      </div>
      <div class="card-body">
        <div>
          <label>ID</label>
          <input type="text" name="id" v-model.trim="id" v-validate="'required|alpha_num|min:4'" class="form-control" :class="{ error: errors.has('id') }" />
          <span class="error">{{ errors.first('id') }}</span>
        </div>
        <div>
          <label>PASSWORD</label>
          <input type="text" name="password" v-model.trim="pwd" v-validate="'required|alpha_num|min:4'" class="form-control" :class="{ error: errors.has('password') }" @keyup.enter="auth"/>
          <span class="error">{{ errors.first('password') }}</span>
        </div>
        <div class="text-right" style="margin-top:10px;">
          <button @click="popSingUp()" class="btn btn-default btn-sm">Sign Up</button>
          <button class="btn btn-success" :disabled="errors.any()" @click="auth()">Login</button>
        </div>
      </div>
    </div>
    <user-info class="pop" v-show="isPop"></user-info>
  </div>
</template>

<script>
import mapState from "vuex"
import UserInfo from "./user/UserInfo.vue"

export default {
  name: 'App',
  components : { UserInfo },
  data: function( ) {
    return {
      id: "",
      pwd: ""
  	}
  },
  computed: {
    getAuth: function() {
      return this.$store.state.auth.auth;
    },
    isPop: function() {
      return this.$store.state.auth.isPop;
    }
  },
  methods: {
  	auth: function( ) {
      this.$validator.validateAll().then(res=>{
          if(res) {
              this.$store.dispatch("auth/updateAuth", {id:this.id, pwd:this.pwd})
          } else {
            this.$noti_warn('You are not input id, password or not enough')
          }
      })
  	},
    popSingUp : function() {
      this.$store.commit("auth/updateIsPop", {isPop : true})
    }
  }
}
</script>

<style scoped>
.title {
  border-bottom:4px solid blue;
}

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

.modal {
  display: block; position: fixed; z-index: 1;
  left: 0; top: 0; width: 100%; height: 100%;
  overflow: auto;
  background-color: grey;/*rgba(0, 0, 0, 0, 4);*/
  opacity: 0.2;
}

.pop {
  position:absolute;
}
</style>

<template>
  <div>
    <div class="container">
      <div class="row">
        <div class="card col-xs-12" style="padding:20px 20px 20px 20px;">
          <div class="card-title">
            <h4>Sign up</h4>
          </div>
          <div class="card-body">
            <div>
              <label>ID</label>
              <input type="text" v-model.trim="user.id" class="form-control" name="id" v-validate="'required|alpha_num|min:4'" :class="{ error: errors.has('id') }" :disabled="isID" />
              <button class="btn btn-primary btn-sm" @click="checkID">Check ID</button>
              <span class="error">{{ errors.first('id') }}</span>
            </div>
            <div>
              <label>PASSWORD</label>
              <input type="text" v-model.trim="user.pwd" class="form-control" name="pwd" v-validate="'required|alpha_num|min:4'" :class="{ error: errors.has('pwd') }" />
              <span class="error">{{ errors.first('pwd') }}</span>
            </div>
            <div>
              <label>NAME</label>
              <input type="text" v-model.trim="user.name" class="form-control" name="name" v-validate="'required|alpha|min:1'" :class="{ error: errors.has('name') }" />
              <span class="error">{{ errors.first('name') }}</span>
            </div>
            <div class="text-right" style="margin-top:10px;">
              <button class="btn btn-default btn-sm" @click="dismiss">Dismiss Me</button>
              <button class="btn btn-success" :disabled="errors.any()" @click="signup">Sign Up</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'user-info',
  computed: {
    ...mapState({user: state => state.auth.user, isID: state => state.auth.isID})
  },
  methods: {
    checkID : function() {
      if (this.user.id == undefined || this.user.id == null || this.user.id.length < 4) {
        this.$noti_warn("You mnust input more than 3 letters. Input and retry it")
        return false
      }

      if (this.isID) {
        this.$noti_warn("Already passed duple checking")
        return false
      }

      this.$store.dispatch("auth/checkID", {id:this.user.id})
    },
  	signup : function() {
      if (!this.isID) {
        this.$noti_warn("Check duple ID and retry it")
        return false
      }

      this.$validator.validateAll().then(res=>{
          if(res) {
              this.$store.dispatch("auth/signUpUser", {user:this.user})
          } else {
            this.$noti_warn('You are not input id, password, name or not enough');
          }
      })
  	},
    dismiss : function() {
      this.$store.commit("auth/updateIsPop", {isPop:false})
    }
  }
}
</script>

<style>

</style>

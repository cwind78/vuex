<template>
  <div>
    <div>
      <label>ID</label>
      <input type="text" v-model.trim="id" class="form-control" />
    </div>
    <div>
      <label>PASSWORD</label>
      <input type="text" v-model.trim="pwd" class="form-control" @keyup.enter="auth"/>
    </div>
    <div>
      <button class="btn btn-success" @click="auth()">Login</button>
    </div>
  </div>
</template>

<script>
import mapState from "vuex"

export default {
  name: 'App',
  data: function( ) {
    return {
      id: "",
      pwd: ""
  	}
  },
  computed: {
    getAuth: function() {
      return this.$store.state.auth.auth;
    }
  },
  methods: {
  	auth: function( ) {
  		this.$store.dispatch("auth/updateAuth", {id:this.id, pwd:this.pwd})
  	}
  }
}
</script>

<style>

</style>

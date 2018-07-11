<template>
  <div>
    <h3>Menu</h3>
    <a v-if="!getAuth" @click="logout">Logout</a>
    <router-link v-else :to="{name : 'Login'}">Login</router-link>
    <router-link v-if="!getAuth" :to="{name : 'HelloWorld'}">Home</router-link>
    <router-link v-if="!getAuth" :to="{name : 'Contact'}">Contact</router-link>
  </div>
</template>

<script>

export default {
  name: 'menus',
  computed: {
  	getAuth : function() {
  	  let auth = this.$store.state.auth.auth;
  	  console.log(auth);
  	  return auth == [] || auth.length == 0
  	}
  },
  methods: {
  	logout : function() {
  	  this.$store.dispatch("auth/dismissAuth", {auth:[]})
  	}
  }
}
</script>

<style>

</style>

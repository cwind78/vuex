<template>
  <div>
    <div>
      <button class="btn" @click="getUserList()">조회</button>
      <p />
      <table class="table table-default table-hover table-striped" id="list">
        <thead>
          <tr>
            <th class="text-center">아이디</th>
            <th class="text-center">이름</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" @click="setUser(user)">
            <td class="text-center">{{user.id}}</td>
            <td>{{user.name}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div>
      <div>
        <label>아이디</label>
        <div><input type="text" v-model="id" />
        </div>
        <label>이름</label>
        <div><input type="text" v-model="name" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'user-list',
  data: function() {
    return {
      id: ""
      , name: ""
    }
  },
  computed: {
    users: function() {
      return this.$store.state.auth.users;
    }
  },
  methods: {
    getUserList: function() {
      this.$store.dispatch("auth/getUserList", {name: null});
    },
    setUser: function(user) {
      this.id = user.id
      this.name = user.name
    }
  }
}
</script>

<style>
</style>
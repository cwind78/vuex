<template>
  <div>
    <table class="table table-default table-hover table-striped" id="list">
      <thead>
        <tr>
          <th class="text-center">아이디</th>
          <th class="text-center">이름</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in users">
          <td class="text-center">{{user.id}}</td>
          <td>{{user.name}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'user-list',
  //computed : mapState([ 'contacts' ])
  computed: {
    ...mapState({users: state => state.auth.users})
  }
}
</script>

<style>
</style>
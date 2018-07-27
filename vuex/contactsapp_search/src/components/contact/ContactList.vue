<template>
  <div>
    <table class="table table-default table-hover table-striped" id="list">
      <thead>
        <tr>
          <th class="text-center">번호</th>
          <th class="text-center">이름</th>
          <th class="text-center">전화번호</th>
          <th class="text-center">주소</th>
        </tr>
      </thead>
      <tbody id="contacts">
        <tr v-for="contact in contacts">
          <td class="text-center">{{contact.no}}</td>
          <td>{{contact.name}}</td>
          <td>{{contact.tell}}</td>
          <td>{{contact.address}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'contact-list',
  //computed : mapState([ 'contacts' ])
  computed: {
    ...mapState({contacts: state => state.contact.contacts})
  }
}
</script>

<style>
</style>
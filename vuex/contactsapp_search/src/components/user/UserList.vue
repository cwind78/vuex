<template>
  <div>
    <div>
      <div class="text-right">
        <button class="btn" @click="getUserList()">조회</button>
        <p />
      </div>
      <div>
        <label>등급</label>
        <span><common-combo data="1" default="1" mode="1" v-on:cmnComboChange="returnSelectedValueAndText"></common-combo></span>
      </div>
      <div>
        <label>성별</label>
        <span><common-combo data="2" default="" mode="0" v-on:cmnComboChange="getGenderCode"></common-combo></span>
      </div>
      <span>조회결과</span>
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
        <span><input type="text" v-model="id" />
        </span>
        <label>이름</label>
        <span><input type="text" v-model="name" />
        </span>
      </div>
    </div>
    <div>
      <label>가격</label>
      <input type="text" name="txt_price" v-model="price" />
      <input type="text" name="txt_price" v-bind:value="vat" />
      <input type="text" name="txt_price" v-model="totl" />
      <input type="text" name="txt_price" v-model="comm" />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import CommonCombo from "../common/combo/CommonCombo.vue"

export default {
  name: 'user-list',
  components : { CommonCombo },
  data: function() {
    return {
      id: ""
      , name: ""
      , price: 0
    }
  },
  created: function() {
    this.getUserList();
  },
  computed: {
    users: function() {
      return this.$store.state.auth.users;
    },
    vat: function() {
      return Math.floor(this.price/10)
    },
    totl: function() {
      return parseInt(this.price) + Math.floor(this.price/10)
    },
    comm: function() {
      return Math.floor(this.price * 0.003)
    }
  },
  methods: {
    getUserList: function() {
      this.$store.dispatch("auth/getUserList", {name: null})
      //alert($("thead th:first").text()) //jquery 사용할 수 있도록 했음
    },
    setUser: function(user) {
      this.id = user.id
      this.name = user.name
    },
    returnSelectedValueAndText: function(payload) {
      alert(payload.value + ", " + payload.text);
    },
    getGenderCode : function(payload) {
      alert(payload.value + ", " + payload.text);
    }
  }
}
</script>

<style>
label {
  float: left;
}
</style>
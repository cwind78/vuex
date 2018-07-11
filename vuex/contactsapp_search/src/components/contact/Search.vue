<template>
  <div>
    <p>
      <!--input type="text" name="user_name" class="form-control" v-model.trim="name" placeholder="이름 : 세글자 이상 입력 후 엔터!" @keyup.enter="keyupEvent" /-->
      <input type="text" name="user_name" class="form-control" v-model.trim="user_name" placeholder="이름 : 세글자 이상 입력 후 엔터!" @keyup.enter="searchContact" />
    </p>
  </div>
</template>

<script>
//import Constant from '../../constant';
//import mapActions from 'vuex'

export default {
  name: 'search',
  data : function() {
    return { user_name : "" }
  },
  /*methods : {
    keyupEvent : function(e) {
      var val = e.target.value;
      alert($("input[name=user_name").val());
      if (val.length >= 2) {
        this.$store.dispatch(Constant.SEARCH_CONTACT, {name : val })
        this.name = "";
      } else {
        this.$store.dispatch(Constant.SEARCH_CONTACT, {name : ''})
      }
    }
  }*/
  methods: {
    //...mapActions('contact', ['searchContact'])
    searchContact : function() {
      if (this.user_name.length < 3) {
        this.$awn.info("Please input more than 3 letters")
        return false;
      }
      this.$store.dispatch('contact/searchContact', {name : this.user_name})
    }
  }
}
</script>

<style>
/*#list {
  width : 600px;
  border : 1px solid black;
  border-collapse : collapse;
}

#list td, #list th {
  border : 1px solid black;
  text-align : center;
}

#list > thead > tr {
  color : yellow;
  background-color : purple;
}*/
</style>

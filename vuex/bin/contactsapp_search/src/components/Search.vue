<template>
  <div>
    <p>
      이름 : <input type="text" v-model.trim="name" placeholder="두글자 이상 입력 후 엔터!" @keyup.enter="keyupEvent" />
    </p>
  </div>
</template>

<script>
import Constant from '../constant';

export default {
  name: 'search',
  data : function() {
    return { name : "" }
  },
  methods : {
    keyupEvent : function(e) {
      var val = e.target.value;
      if (val.length >= 2) {
        this.$store.dispatch(Constant.SEARCH_CONTACT, {name : val })
        this.name = "";
      } else {
        this.$store.dispatch(Constant.SEARCH_CONTACT, {name : ''})
      }
    }
  }
}
</script>

<style>
#list {
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
}
</style>

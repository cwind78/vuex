<template>
  <div>
    <p>
      <div class="input-group">
        <input type="text" name="user_name" class="form-control" v-model.trim="user_name" placeholder="이름 : 세글자 이상 입력 후 엔터!" @keyup.enter="searchUser" />
        <span class="input-group-btn">
          <button class="btn btn-primary" @click="searchUser">
            <font-awesome-icon icon="search"></font-awesome-icon>
          </button>
        </span>
      </div>
    </p>
  </div>
</template>

<script>

export default {
  name: 'search-user',
  data : function() {
    return { user_name : "" }
  },
  methods: {
    //...mapActions('contact', ['searchContact'])
    searchUser : function() {
      if (this.user_name.length < 3) {
        //this.$awn.info("Please input more than 3 letters")
        this.$noti_warn('Please input more than 3 letters');
        return false;
      }
      this.$store.dispatch('auth/getUseList', {name : this.user_name})
    }
  }
}
</script>

<style>

</style>

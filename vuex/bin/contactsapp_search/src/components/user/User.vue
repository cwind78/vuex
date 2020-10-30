<template>
  <div>
    <search-user placeholder="두 글자 이상 입력 후 엔터!"></search-user>
    <user-list></user-list>
  </div>
</template>

<script>
import SearchUser from './SearchUser.vue';
import UserList from './UserList.vue';

export default {
  name: 'User',
  components : {SearchUser, UserList}
}
</script>

<style>

</style>

<template>
  <div>
    <search placeholder="두 글자 이상 입력 후 엔터!"></search>
    <contact-list></contact-list>
  </div>
</template>

<script>
import Search from './Search.vue';
import ContactList from './ContactList.vue';

export default {
  name: 'App',
  components : {Search, ContactList}
}
</script>

<style>

</style>

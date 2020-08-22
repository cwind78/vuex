<template>
	<div>
		<select id="cbo_common_combo" @change="returnSelectedValueAndText">
			<option v-if="mode=='0'" value="ALL">전체</option>
			<option v-if="mode=='1'" value="">선택</option>
			<option v-for="code in codes"
			        v-bind:value="code.code"
			        :selected="code.code == code_default">{{code.text}}
			</option>
		</select>
	</div>
</template>

<script>


export default {
  name: 'App',
  data: function( ) {
    return {
    	code_group: this.data
    	, code_mode: this.mode
    	, code_default: this.default
    	, rValue: {
    		value: ""
    		, text: ""
    	}
  	}
  },
  //data : 코드그룹
  //default : 콤보박스에서 선택할 기본값, 값이 없으면 첫번째 선택
  /*mode : 0 -> 첫번째 전체 추가
           1 -> 첫번째 선택 추가
           2 -> 코드 그룹의 조회 결과만 출력
  */
  props : ['data', 'default', 'mode'],
  created: function() {
  	this.getCodeList();
  },
  computed: {
  	codes: function() {
      return this.$store.state.auth.codes;
    }
  },
  methods: {
    returnSelectedValueAndText: function() {
        this.rValue.value = $("#cbo_common_combo").val()
        this.rValue.text = $("#cbo_common_combo").find("option:checked").text()
       
    	this.$emit('cmnComboChange', this.rValue);
    },
    getCodeList: function() {
      this.$store.dispatch("auth/getCommonCodeList", {code_group: this.code_group})
    }
  }
}
</script>

<style>
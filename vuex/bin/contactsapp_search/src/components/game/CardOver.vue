<template>
	<div>
		<div>
			카드 뒤집기
		</div>
		<div class="text-center">
			<div class="card" v-on:click="getCardBack()">
				<div class="front"></div>
				<div class="back">1</div>
			</div>
			<div>
				<a class="btn" v-on:click="getCardFront()">다시하기</a>
			</div>
		</div>
	</div>
</template>
<script>


export default {
  name: 'App',
  data: function( ) {
    return {
  	}
  },
  created: function() {
  },
  computed: {
  },
  methods: {
    getCardBack: function() {
    	$(".card").removeClass("backRotate")
    	$(".card").addClass("cardRotate")
    },
    getCardFront: function() {
    	$(".card").removeClass("cardRotate")
    	$(".card").addClass("backRotate")
    }
  }
}
</script>

<style>
.card{width:100px; height:150px; position:relative; display:inline-block; margin-right:50px;}
.front{position:absolute; width:100px; height:150px; background:#ccc; top:0; left:0;}
.back{position:absolute; width:100px; height:150px; background:#ff0; top:0; left:0; transform:rotateY(90deg);}
.cardRotate .front{opacity:1;animation: rotateAni 0.5s 1; transform:rotateY(90deg);}
.cardRotate .back{opacity:1;animation: rotateAni2 0.5s 0.5s 1 backwards; transform:rotateY(0);}
.backRotate .front{animation: backAni 0.5s   1; opacity:1;}
.backRotate .back{opacity:0;}

@keyframes rotateAni{
  0%{transform:rotateY(0);}
  100%{transform:rotateY(90deg);}
}
@keyframes rotateAni2{
  0%{transform:rotateY(-90deg);}
  100%{transform:rotateY(0deg);}
}

@keyframes backAni{
  0%{transform:rotateY(90deg);}
  100%{transform:rotateY(0deg);}
}
</style>
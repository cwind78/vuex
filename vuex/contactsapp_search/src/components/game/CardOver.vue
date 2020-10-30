<template>
	<div>
		<div>
			카드 뒤집기
		</div>
		<div class="text-center">
			<div class="card" v-on:click="getCardBack()">
				<div class="front"></div>
				<div class="back">{{ card_num }}</div>
			</div>
      <div>
        결과가 5이상 나오면 10점(사용시 -1점 차감 하여 총 9점)이 적립 됩니다.
        반대의 경우 사용시 -1점 차감 됩니다.
      </div>
      <div>
        결과 : <span v-if="card_num>=5">승리</span><span v-if="card_num<5">패배</span>
      </div>
			<div>
				<a class="btn" v-on:click="getCardFront()">다시하기</a>
			</div>
		</div>
	</div>
</template>
<script>
import axios from 'axios'
import Constant from '../../constant'

export default {
  name: 'App',
  data: function( ) {
    return {
      card_info: {}
      , card_num : ""
  	}
  },
  created: function() {
  },
  computed: {
  },
  methods: {
    getCardBack: function() {
      //뒤집지 않았다면 뒤집기
      if (!$(".card").hasClass("cardRotate")) {
        this.getRandomCardNum()
    	  $(".card").removeClass("backRotate")
    	  $(".card").addClass("cardRotate")
      }
    },
    getCardFront: function() {
    	$(".card").removeClass("cardRotate")
    	$(".card").addClass("backRotate")
    },
    getRandomCardNum: function() {
      axios.get(Constant.BASE_URL + "game/getRandomCardNum/")
        .then((response) => {
          if (response.data == {} || response.data == null) {
            Vue.prototype.$noti_warn('카드 뒤집기 결과를 처리하지 못했습니다')
          } else {
            this.card_info = response.data;
            this.card_num = this.card_info["card_num"]
          }
        })
        .catch(function (error) {
          alert('카드 뒤집기 결과를 가져오는데 실패 했습니다.');
        })
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
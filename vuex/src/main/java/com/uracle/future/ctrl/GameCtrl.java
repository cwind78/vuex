package com.uracle.future.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uracle.future.mapper.GameDao;
import com.uracle.future.vo.CardInfo;
import com.uracle.future.vo.User;

@Controller
public class GameCtrl {
	@Autowired
	GameDao gameDao;
	
	@GetMapping("/game/getRandomCardNum")
    @ResponseBody
	public CardInfo getRandomCardNum(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User user = new User();
		user.setId(session.getAttribute("ID").toString());
		
		//카드 뒤집기 랜덤 번호
		int value = (int)(Math.random()*10);
		if (value > 5) {
			//포인트 9점 추가 : 10점 부여, 사용으로 인한 1점 차감
			user.setPnt(9);
		} else {
			//포인트 1점 차감
			user.setPnt(-1);
		}
		
		List<User> pnt = gameDao.getPntById(user); 
		if (pnt != null && pnt.size() > 0) {
			gameDao.updPntById(user);
		} else {
			gameDao.setPntById(user);
		}
		
		CardInfo cInfo = new CardInfo();
		
		cInfo.setCard_num(String.valueOf(value));
	    return cInfo;
	}
}

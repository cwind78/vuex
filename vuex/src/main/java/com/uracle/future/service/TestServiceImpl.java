package com.uracle.future.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uracle.future.mapper.TestDao;
import com.uracle.future.vo.Result;
import com.uracle.future.vo.User;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	TestDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor={Exception.class})
	public Result setPntById() throws Exception {
		Result result = new Result();
		result.setResult("1");
		result.setMessage("처리가 완료 되었습니다.");
		
		User user = new User();
		user.setId("1111");
		user.setPnt(50);
		try {
			if (dao.updUserLastLogin(user) > 0) {
				if (dao.updIdPnt(user) <= 0) {
					throw new Exception("포인트 업데이트를 실패 하였습니다.");	
				}
			} else {
				throw new Exception("로그인 일시 업데이트를 실패 하였습니다.");
			}
			return result;
		} catch (Exception e) {
			//아래를 하지 않으면 transactionManager가 예외를 잡지 못해 롤백을 하지 않는다.
			//아니면 그냥 try, catch를 빼버려서 예외시 롤백이 되도록 한다
			throw new Exception(e.getMessage());
		}
	}
}

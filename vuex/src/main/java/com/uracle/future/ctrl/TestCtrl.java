package com.uracle.future.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uracle.future.service.TestService;
import com.uracle.future.vo.Result;

@Controller
public class TestCtrl {
	@Autowired
	TestService service;
	
	@GetMapping("/test/setPntById")
	@ResponseBody
	public Result setPntById() {
		Result result = null;
		try {
			result = service.setPntById();
		} catch (Exception e) {
			result = new Result();
			result.setResult("-1");
			result.setMessage(e.getMessage());
		}
		
		return result;
	}
}

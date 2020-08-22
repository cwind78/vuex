package com.uracle.future.ctrl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.uracle.future.mapper.CodeDao;
import com.uracle.future.vo.Code;

@Controller
public class CodeCtrl {
	@Autowired
	CodeDao codeDao;
	
	@GetMapping("/common/codeList")
    @ResponseBody
	public List<Code> getCodeList(@RequestParam(value="code_group", required=true) String code_group, HttpServletRequest request) throws Exception {
		Code code = new Code();
		code.setCode_group(code_group);
		List<Code> codes = codeDao.getCodeList(code);
		
		return codes; 
	}
}

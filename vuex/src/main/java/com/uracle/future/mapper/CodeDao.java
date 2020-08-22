package com.uracle.future.mapper;

import java.util.List;

import com.uracle.future.vo.Code;


public interface CodeDao {
	public List<Code> getCodeList(Code code) throws Exception;
}

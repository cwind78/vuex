package com.uracle.future.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.uracle.future.vo.User;


@Mapper
@Repository
public interface MainMapper {
	public int getIdPntCntById(User user) throws Exception;
	public int insertIdPnt(User user) throws Exception;
	public int updateIdPnt(User user) throws Exception;
	public int updatePnt(User user) throws Exception;
	public int getPntById(User user) throws Exception;
	public User getUserInfoByNaverInfo(User user) throws Exception;
}

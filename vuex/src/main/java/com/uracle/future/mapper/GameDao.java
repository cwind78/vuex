package com.uracle.future.mapper;

import java.util.List;
import com.uracle.future.vo.User;

public interface GameDao {
	public List<User> getPntById(User user) throws Exception;
	public int setPntById(User user) throws Exception;
	public int updPntById(User user) throws Exception;
}

package com.uracle.future.mapper;

import java.util.List;
import com.uracle.future.vo.Contact;
import com.uracle.future.vo.Menu;
import com.uracle.future.vo.User;

public interface ContactDao {
	public List<Contact> getContact(Contact contact) throws Exception;
	public List<User> checkLogin(User user) throws Exception;
	public Integer testUserInsert() throws Exception;
	public Integer testContactInsert() throws Exception;
	public Integer signUp(User user) throws Exception;
	public Integer checkDupleID(User user) throws Exception;
	public List<Menu> getMenuList(User user) throws Exception;
	public List<User> getUserList(User user) throws Exception;
}

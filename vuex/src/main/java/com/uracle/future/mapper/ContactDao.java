package com.uracle.future.mapper;

import java.util.List;
import com.uracle.future.vo.Contact;
import com.uracle.future.vo.User;

public interface ContactDao {
	public List<Contact> getContact(Contact contact) throws Exception;
	public List<User> checkLogin(User user) throws Exception;
}

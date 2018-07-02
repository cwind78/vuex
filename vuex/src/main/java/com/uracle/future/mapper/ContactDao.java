package com.uracle.future.mapper;

import java.util.List;
import com.uracle.future.vo.Contact;

public interface ContactDao {
	public List<Contact> getContact(Contact contact) throws Exception;
}

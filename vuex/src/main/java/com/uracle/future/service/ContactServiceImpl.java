package com.uracle.future.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uracle.future.mapper.ContactDao;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactDao contactDao;

	@Transactional
	public Integer test() throws Exception {
		try {
			Integer val = 0;
			val += contactDao.testUserInsert();
			val += contactDao.testContactInsert();
			throw new Exception();
			
		} catch (Exception e) {
			
		}
		return 0;
	}
}

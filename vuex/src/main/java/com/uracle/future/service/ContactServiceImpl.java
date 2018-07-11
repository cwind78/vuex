package com.uracle.future.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.uracle.future.mapper.ContactDao;

@Service("contactService")
@Transactional(rollbackFor = Exception.class)
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactDao contactDao;

	@Transactional(propagation = Propagation.REQUIRED, transactionManager = "transactionManager", rollbackFor = RuntimeException.class)
	public Integer test() throws Exception {
		Integer val = 0;
		val += contactDao.testUserInsert();
		val += contactDao.testContactInsert();
		throw new RuntimeException("Roll me back!!");			
	}
}

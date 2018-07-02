package com.uracle.future.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uracle.future.mapper.ContactDao;
import com.uracle.future.vo.Contact;

@Controller
public class ContactCtrl {
	@Autowired
	ContactDao contactDao;
	
	@GetMapping("/contact/{name}") // requestmapping method=RequestMethod.GET가 포함되어 있다.
    @ResponseBody
	public List<Contact> getContact(@PathVariable("name") String name) throws Exception {
		Contact contact = new Contact();
		contact.setName(name);
		return contactDao.getContact(contact);
	}

}

package com.uracle.future.ctrl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.uracle.future.mapper.ContactDao;
import com.uracle.future.service.ContactService;
import com.uracle.future.vo.Contact;
import com.uracle.future.vo.Menu;
import com.uracle.future.vo.Result;
import com.uracle.future.vo.User;

@Controller
public class ContactCtrl {
	@Autowired
	ContactDao contactDao;
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("/contact/{name}") // requestmapping method=RequestMethod.GET가 포함되어 있다.
    @ResponseBody
	public List<Contact> getContact(@PathVariable("name") String name,
			HttpServletRequest request) throws Exception {
		Contact contact = new Contact();
		contact.setName(name);
		return contactDao.getContact(contact);
	}

	@GetMapping("/auth/{id}/{pwd}")
    @ResponseBody
	public List<User> checkLogin(@PathVariable("id") String id,
			@PathVariable("pwd") String pwd,
			HttpServletRequest request) throws Exception {
		User user = new User();
		user.setId(id);
		user.setPwd(pwd);
		
		List<User> list = contactDao.checkLogin(user);
		if (list != null && list.size() > 0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("ID", list.get(0).getId());
			session.setAttribute("NAME", list.get(0).getName());
			session.setMaxInactiveInterval(60*120);
		}
		
		return list; 
	}
	
	@PostMapping("/user/signup")
    @ResponseBody
	public List<User> signUp(@RequestBody User user,
			HttpServletRequest request) throws Exception {
		Integer insert_count = contactDao.signUp(user);
		List<User> list = new ArrayList<User>();
		list.add(insert_count>0?user:null);
		return list; 
	}
	
	@GetMapping("/user/checkid/{id}")
    @ResponseBody
	public List<User> checkDupleID(@PathVariable("id") String id,
			HttpServletRequest request) throws Exception {
		User user = new User();
		user.setId(id);
		Integer count = contactDao.checkDupleID(user);
		List<User> list = new ArrayList<User>();
		list.add(count>0?user:null);
		return list; 
	}
	
	@GetMapping("/user")
    @ResponseBody
	public List<User> signUp(@RequestParam(value="name", required=false) String name,
			HttpServletRequest request) throws Exception {
		User user = new User();
		user.setName(name);
		List<User> list = contactDao.getUserList(user);
		
		return list; 
	}
	
	@GetMapping("/menu")
    @ResponseBody
	public List<Menu> getMenuList(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User user = new User();
		user.setId(session.getAttribute("ID").toString());
		System.out.println("id="+user.getId());
		List<Menu> list = contactDao.getMenuList(user);
		return list; 
	}
	
	@GetMapping("/test")
    @ResponseBody
	public List<Result> test(HttpServletRequest request) throws Exception {
		Result result = new Result();
		List<Result> list = new ArrayList<Result>();
		
		Integer val = contactService.test();
		result.setResult(val>0?"1":"-1");
		list.add(result);
		
		return list; 
	}
}

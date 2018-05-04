package myspring.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService service;

	//JAVA list object -> Json data
	 @ResponseBody
	 @RequestMapping("/users.do")
	 public List<UserVO> getUserJsonList() {
		 return service.getUserList();
	}
	
	
	@RequestMapping("/getUser.do")
	public ModelAndView getUser(@RequestParam String id) {
		UserVO user = service.getUser(id);
		return new ModelAndView("userInfo.jsp", "user", user);
	}
	
	@RequestMapping("/getAllUser.do")
	public ModelAndView getAllUser() {
		ArrayList<UserVO> listUser = (ArrayList<UserVO>) service.getUserList();
		return new ModelAndView("userList.jsp", "list", listUser);
	}
	
}

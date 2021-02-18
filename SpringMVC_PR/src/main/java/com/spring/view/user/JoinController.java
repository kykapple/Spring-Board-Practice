package com.spring.view.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.user.UserService;
import com.spring.biz.user.UserVO;

@Controller
public class JoinController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/join.do")
	public String join(UserVO vo) {
		if(userService.joinUser(vo)) {
			return "login.jsp";
		}
		else {
			return "common/joinError.jsp";
		}
	}
}

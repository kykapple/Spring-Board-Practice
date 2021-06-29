package com.spring.demo.controller;

import com.spring.demo.domain.UserVO;
import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/joinForm.do")
    public String joinForm() {
        return "joinForm";
    }

//    @PostMapping("/join.do")
//    public String join(HttpServletRequest request) {
//        UserVO vo = new UserVO();
//        vo.setId(request.getParameter("id"));
//        vo.setPassword(request.getParameter("password"));
//        vo.setName(request.getParameter("name"));
//
//        userService.joinUser(vo);
//
//        return "alert/joinSuccess";
//    }


    @PostMapping("/join.do")
    public String join(UserVO vo) {
        userService.joinUser(vo);

        return "alert/joinSuccess";
    }

//    @PostMapping("/login.do")
//    public String login(HttpServletRequest request, HttpSession session) {
//        String id = request.getParameter("id");
//        String password = request.getParameter("password");
//        UserVO input = new UserVO(id, password);
//
//        if(id.equals("") || password.equals(""))
//            return "alert/loginError";
//
//        UserVO vo = userService.getUser(input);
//        if(vo != null) {
//            session.setAttribute("welcomeMessage", vo.getName() + " 님 환영합니다:)");
//            return "redirect:boardList.do";
//        }
//
//        return "login";
//    }

    @PostMapping("/login.do")
    public String login(UserVO input, HttpSession session) {
        if(input.getId().equals("") || input.getPassword().equals(""))
            return "alert/loginError";

        UserVO vo = userService.getUser(input);
        if(vo != null) {
            session.setAttribute("userName", vo.getName());
            session.setAttribute("welcomeMessage", vo.getName() + " 님 환영합니다:)");
            return "redirect:boardList.do";
        }

        return "alert/loginFailed";
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}

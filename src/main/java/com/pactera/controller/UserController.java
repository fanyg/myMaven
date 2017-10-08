package com.pactera.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pactera.domain.UserInfo;
import com.pactera.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
    
    public UserController() {
        System.out.println("UserController");
    }

    @Resource
    private IUserService userService;
    
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model) {
        System.out.println("UserController showUser");
        int id = Integer.parseInt(request.getParameter("id"));  
        UserInfo user = userService.getUserById(id); 
        System.out.println("-------"+user.toString()+"========");
        model.addAttribute("user", user);  
        return "showUser";  
    }
    
}

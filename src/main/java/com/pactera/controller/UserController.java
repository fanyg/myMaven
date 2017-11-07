package com.pactera.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pactera.domain.UserInfo;
import com.pactera.service.IUserService;
import com.pactera.service.impl.MultiThreadProcessService;
import com.pactera.service.impl.MultiThreadService2;

@Controller
@RequestMapping("/user")
public class UserController {
    
    public UserController() {
        System.out.println("UserController");
    }

    @Resource
    private IUserService userService;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private MultiThreadProcessService multiThreadProcessService;

    
    
    
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model) {
        System.out.println("UserController showUser");
        int id = Integer.parseInt(request.getParameter("id"));  
        UserInfo user = userService.getUserById(id); 
        System.out.println("-------"+user.toString()+"========");
        model.addAttribute("user", user);  
        return "showUser";  
    }
    
    @RequestMapping("/showUser2")
    public String synchro(HttpServletRequest request,Model model) {

    	String flag="fail";
    	
    	Future<String> qwe = taskExecutor.submit(new MultiThreadService2(multiThreadProcessService));
    	
    	System.out.println("11111");
    	try {
		flag=qwe.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
    	
    	
    	return flag;
    	
    }
    
}

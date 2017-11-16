package com.pactera.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pactera.domain.UserInfo;
import com.pactera.service.IUserService;
import com.pactera.service.impl.MultiThreadProcessService;
import com.pactera.service.impl.MultiThreadService2;
import com.pactera.service.impl.RunnableDemo;

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
    @Autowired
    private RunnableDemo demo;

    
    
    
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
    
    @RequestMapping("/insertUser")
    public String insertUser(HttpServletRequest request,Model model) throws InterruptedException {
    	Thread.currentThread().sleep(5000);
    	UserInfo userInfo=new UserInfo();
    	userInfo.setLoginPhoneNumber("18910160850");
    	userInfo.setCifId("18910160850");
    	userService.insertUser(userInfo);
    	userService.selectByCustomerId("18910160850");
    	
        return "showUser";  
    }

    @RequestMapping("/testThread")
    public String testThread(HttpServletRequest request,Model model) throws InterruptedException {
    	
    	UserInfo userInfo=new UserInfo();
    	userInfo.setLoginPhoneNumber("18910160850");
    	userInfo.setCifId("18910160850");
    	demo.setUserInfo(userInfo);
    	taskExecutor.execute(demo);	
    	taskExecutor.execute(demo);	
    	taskExecutor.execute(demo);	
    	taskExecutor.execute(demo);	
    	taskExecutor.execute(demo);	

    	
    	System.out.println("GameOver.......");
    	return "success";  
    }
    @RequestMapping("/deleteUser")
    @Transactional
    public String deleteUser(HttpServletRequest request,Model model) throws InterruptedException {
    	
    	try {    		
    		
    		userService.deleteByPrimaryKey(529);
    		UserInfo userInfo=new UserInfo();
    		userInfo.setLoginPhoneNumber("18910160850");
    		userInfo.setCifId("18910160850");//重复插入加事务，失败时可回滚
    		userService.insertUser(userInfo);
    		
    	}catch (Exception e) {
			System.out.println("我睡醒了。。。");
			throw new RuntimeException();//如果用try catch 捕获异常，如果不抛出运行时异常，那么事务不会回滚，
		}
    	
        return "success";  
    }
    
}

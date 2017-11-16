package com.pactera.service.impl;

import javax.annotation.Resource;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.pactera.domain.UserInfo;
import com.pactera.service.IUserService;
@Service
public class RunnableDemo implements Runnable{
	
    @Autowired
    private IUserService userService;
    
    private UserInfo userInfo;


	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	@Transactional
	public  void cs() {
		
			
			UserInfo count = userService.selectByCustomerId("18910160850");
			if(count==null) {			
				userService.insertUser(userInfo);
			}else {
				userInfo.setClientName("110");
				userService.updateByCustomerId(userInfo);
			}

	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ)
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+"我要睡觉了");

		try {
			Thread.currentThread().sleep(5000);
		
			
			System.out.println(Thread.currentThread().getName()+"我睡醒了");
//		    synchronized (RunnableDemo.class) {
				UserInfo count = userService.selectByCustomerId("18910160850");
				if(count==null) {			
					userService.insertUser(userInfo);
				}else {
					userInfo.setClientName("110");
					userService.updateByCustomerId(userInfo);
				}
				
//		   }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

}

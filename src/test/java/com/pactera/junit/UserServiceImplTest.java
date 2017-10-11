package com.pactera.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pactera.domain.UserInfo;
import com.pactera.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml","classpath*:/spring-mybatis.xml"})
public class UserServiceImplTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	public IUserService userService;
	@Test
	public void testUserServiceImpl() {
		UserInfo userInfo = userService.getUserById(1);
		System.out.println("userInfo is"+userInfo.getBankCard());
	}

}

package com.pactera.junit;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pactera.domain.MultiThreadConfig;
import com.pactera.service.impl.MultiThreadProcessService;
import com.pactera.service.impl.MultiThreadService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-mvc.xml","classpath:/spring-mybatis.xml"})
public class MultiThreadTest {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private MultiThreadProcessService multiThreadProcessService;
    
    @Test
    public void test() {
        
        int n = 20;
        for (int i = 0; i < n; i++) {
            taskExecutor.execute(new MultiThreadService(multiThreadProcessService));
            System.out.println("int i is " + i + ", now threadpool active threads totalnum is " + taskExecutor.getActiveCount());
        }
        
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

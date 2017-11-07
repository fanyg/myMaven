package com.pactera.service.impl;

import java.util.concurrent.Callable;

/**
 * 多线程并发处理demo
 * @author daniel.zhao
 *
 */
public class MultiThreadService2 implements Callable<String> {

    private MultiThreadProcessService multiThreadProcessService;
    
    public MultiThreadService2() {
    }
    
    public MultiThreadService2(MultiThreadProcessService multiThreadProcessService) {
        this.multiThreadProcessService = multiThreadProcessService;
    }
    
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.currentThread().sleep(10000);
		return "success";
	}

}

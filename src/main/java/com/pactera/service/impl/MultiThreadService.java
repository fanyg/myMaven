package com.pactera.service.impl;

/**
 * 多线程并发处理demo
 * @author daniel.zhao
 *
 */
public class MultiThreadService implements Runnable {

    private MultiThreadProcessService multiThreadProcessService;
    
    public MultiThreadService() {
    }
    
    public MultiThreadService(MultiThreadProcessService multiThreadProcessService) {
        this.multiThreadProcessService = multiThreadProcessService;
    }
    
    @Override
    public void run() {
        multiThreadProcessService.processSomething();
    }

}

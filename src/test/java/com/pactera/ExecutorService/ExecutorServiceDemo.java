package com.pactera.ExecutorService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class ExecutorServiceDemo {

	/**
	 * 线程池
	 */
	@Test
  public void test_newFixedThreadPool() {
	  
	    int NUMBER = 5;
	    ExecutorService executor = Executors.newFixedThreadPool(NUMBER);
	    Map<String, Future<UserThreadInfo>> maps = new HashMap<>();
	    
	    maps.put("account",executor.submit(new CheckAccountTask("111")));
        maps.put("password",executor.submit(new CheckPasswordTask("222")));
        maps.put("identity",executor.submit(new CheckIdentityTask("333")));
  	    System.out.println(Thread.currentThread().getName());
  	    System.out.println(maps.size());
            maps.forEach((k,v) -> {
				try {    
                    switch (k) {
                        case "account":
							System.out.println(v.get().isOpenAccount());
                            break;
                        case "password":
                        	System.out.println(v.get().isPayPasswordSet());
                            break;
                        case "identity":
                        	System.out.println(v.get().isAuth());
                            break;  
                    }
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
            });

	  
  }
  
  private class CheckAccountTask implements Callable<UserThreadInfo> {

      private String id;

      public CheckAccountTask(String id) {
          this.id = id;
      }
      UserThreadInfo info = null;
      @Override
      public UserThreadInfo call() {
          try {
        	  System.out.println(Thread.currentThread().getName());
        	  Thread.sleep(10000);
        	  info=new UserThreadInfo();
        	  info.setOpenAccount(true);
          } catch (Exception e) {
              e.printStackTrace();
          }
          return info;
      }
  }
  
  private class CheckPasswordTask implements Callable<UserThreadInfo> {

      private String id;

      public CheckPasswordTask(String id) {
          this.id = id;
      }
      UserThreadInfo info = null;
      @Override
      public UserThreadInfo call() {
          try {
        	  System.out.println(Thread.currentThread().getName());
              info = new UserThreadInfo();
              info.setPayPasswordSet(true);

          } catch (Exception e) {
              e.printStackTrace();
          }
          return info;
      }
  }
  
  private class CheckIdentityTask implements Callable<UserThreadInfo> {

      private String id;
      public CheckIdentityTask(String id) {
          this.id = id;
      }
      UserThreadInfo result;

      @Override
      public UserThreadInfo call() {
          try {
        	  System.out.println(Thread.currentThread().getName());
              result = new UserThreadInfo();
              result.setAuth(true);
          } catch (Exception e) {
              e.printStackTrace();
          }
          return result;
      }
  }
  
}

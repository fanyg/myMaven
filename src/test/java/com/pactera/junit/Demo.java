package com.pactera.junit;

public class Demo {

	public static void main(String[] args) {
		Demo demo=new Demo();
		Demo demo2=new Demo();
		Demo demo3=null;
		
		System.out.println(demo==demo2);//false   普通对象==和equals 是一样的
		System.out.println(demo.equals(demo2));//false
		System.out.println(demo.equals(""));
		System.out.println(demo3.equals(""));
		
		
		String qwe="123";
		String qwe2="123";
		
		System.out.println(qwe.equals(qwe2));//true
		System.out.println(qwe==qwe2);//true
		
		String q=new String("123");
		String q2=new String("123");
		System.out.println(q.equals(q2));//true  String对象复写的了equals 方法
		System.out.println(q==q2);//false
		
		
		
	}
}

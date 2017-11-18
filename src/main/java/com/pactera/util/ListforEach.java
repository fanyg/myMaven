package com.pactera.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.codehaus.jackson.map.util.Comparators;
import org.junit.Test;

public class ListforEach {

	@Test
	public void test01() {
		List<String> names=new ArrayList<String>();
		names.add("张三");
		names.add("李四");
		names.add("王五");
/*		//常规写法1
		for(int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
		}
		//常规写法2
		for(String name:names) {
			System.out.println(name);
		}
*/		
		//java1.8   Consumer 接口表示执行在单个参数上的操作。 
		names.forEach((String name)->{System.out.println(name);});
		names.forEach(name->{System.out.println(name);});
	}
	@Test
	public void test02() {
/*		List<Integer> list1=new ArrayList<Integer>();
		list1.add(5);
		list1.add(6);
		list1.add(3);
		list1.add(7);
		list1.add(2);
		list1.add(9);*/
		//List<Integer> list1=Arrays.asList(5,6,3,7,2,9);
		List<String> list1=Arrays.asList("tam","tdasd","asdas","asda","asd","asdas");
		Collections.sort(list1);
		list1.forEach(list->System.out.println(list));
	}
	@Test
	public void test3() {
		List<String> list1=Arrays.asList("tam","tdasd","asdas","asda","asd","asdas");
		System.out.println(list1);//[tam, tdasd, asdas, asda, asd, asdas]
		String a="50"; String b="100";
		int flag= a.compareTo(b);//自然顺序
		System.out.println(flag);
		//集合排序 自然排序
		Collections.sort(list1);
		System.out.println(list1);//[asd, asda, asdas, asdas, tam, tdasd]
		//自然排序 同上
		Collections.sort(list1, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg0.compareTo(arg1);
			}
			
		});
		
		System.out.println(list1);//[asd, asda, asdas, asdas, tam, tdasd]
		
		//逆自然排序
		Collections.sort(list1, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				//return arg0.compareTo(arg1);
				return arg1.compareTo(arg0);
			}
			
		});
		
		System.out.println(list1);//[tdasd, tam, asdas, asdas, asda, asd]

	}
	@Test
	public void test4() {
		String[] str=new String[] {"tam","tdasd","asdas","asda","asd","asdas"};
		
		Arrays.sort(str);
		
		for(String arr:str) {
			System.out.println(arr);//asd  asda asdas asdas tam tdasd
		}
		
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				return arg1.compareTo(arg0);  //tdasd tam asdas asdas asda asd 
			}
			
		});;
		for(String arr:str) {
			System.out.print(arr+" ");
		}
	}
	@Test
	public void test5() {
		
		String[] arr=new String[] {"aaa","abb","abc","abcd","qwe","acsd"};
		Arrays.sort(arr, (a,b)->a.compareTo(b));
		for(String str:arr) {
			System.out.print(str+" ");//aaa abb abc abcd acsd qwe
		}
	}
}

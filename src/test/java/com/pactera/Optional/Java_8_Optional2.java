package com.pactera.Optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.pactera.java8.Formula;

public class Java_8_Optional2 {

	/**
	 *一：接口的默认方法:Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可，这个特征又叫做扩展方法，
	 *接口不能用于实例化对象。
	 *接口没有构造方法。
	 *接口中所有的方法必须是抽象方法。
	 *接口不能包含成员变量，除了 static 和 final 变量
	 */
	public void test01() {
		Formula formula=new Formula() {

			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		};
		//实现了Formula接口的子类只需要实现一个calculate方法，默认方法sqrt将在子类上可以直接使用。
		formula.calculate(0);
		formula.sqrt(0);
	}
	/**
	 * Lambda 表达式['læmdə]
	 */
	@Test
	public void test2() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		 
/*		//old
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return b.compareTo(a);
		    }
		});
		System.out.println(names);
*/		
		//新特性
/*		Collections.sort(names, (String a, String b) -> {
		    return b.compareTo(a);
		});*/
		//对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字
		//Collections.sort(names, (String a, String b) -> b.compareTo(a));
		Collections.sort(names, (a,b) -> b.compareTo(a));
		System.out.println(names);
		
	}
}

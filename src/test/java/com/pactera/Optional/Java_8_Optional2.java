package com.pactera.Optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

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
	 * Lambda 表达式['læmdə],是一个匿名函数。
	 * 每一个lambda表达式都对应一个类型，通常是接口类型
	 * “函数式接口”是指仅仅只包含一个抽象方法的接口，每一个该类型的lambda表达式都会被匹配到这个抽象方法
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
	@Test
	/**测试lambda
	 * 
	 */
	public void test3() {
/*		Formula c=new Formula() {

			@Override
			public double calculate(int a) {
				// TODO Auto-generated method stub
				return 10*a;
			}
			
		};
		
		System.out.println(c.calculate(10));*/
		
		Formula c1=a->10*a;
		c1.calculate(10);
		System.out.println(c1.calculate(10));
		
		
		List<Integer> list=Arrays.asList(1,5,7,9,3);
//		Predicate predicate= (String a)->{a>4;};
		//list.stream().filter(a -> a>4);
		long num = list.stream().filter( a ->  a > 4 ).count();
		
	}
	
	
/*	有多种方式生成 Stream Source：
	从 Collection 和数组
	Collection.stream()
	Collection.parallelStream()
	Arrays.stream(T array) or Stream.of()
	从 BufferedReader
	java.io.BufferedReader.lines()
	静态工厂
	java.util.stream.IntStream.range()
	java.nio.file.Files.walk()
	自己构建
	java.util.Spliterator
	其它
	Random.ints()
	BitSet.stream()
	Pattern.splitAsStream(java.lang.CharSequence)
	JarFile.stream()*/
	@Test
	public void Stream() {
		String [] strArray=new String[] {"12","123","124","157"};
		java.util.stream.Stream<String> stream = java.util.stream.Stream.of(strArray);
		java.util.stream.Stream<String> stream2 = Arrays.stream(strArray);
		
		IntStream.of(new int[]{1, 2, 3}).forEach((s)->{System.out.println(s);});
	}
}

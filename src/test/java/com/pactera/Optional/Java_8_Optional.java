package com.pactera.Optional;

import java.util.Optional;

import org.junit.Test;

public class Java_8_Optional {

	/**
	 * Java 8引入了一个新的Optional类
	 * 这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
	 */
	
	/**
	 * 为非null的值创建一个Optional
	 */
	@Test
	public void test_of() {
		//调用工厂方法创建Optional实例
		Optional<String> name = Optional.of("Sanaulla");
		//传入参数为null，抛出NullPointerException.
		Optional<String> someNull = Optional.of(null);//抛异常
		System.out.println(name+"==="+someNull);
	}
	
	/**
	 * 	//下面创建了一个不包含任何值的Optional实例
	 * //例如，值为'null'     //isPresent(),
	 */
	@Test
	public void test_ofNullable() {

//		Optional empty = Optional.ofNullable(null);
		Optional empty = Optional.ofNullable("abc");
		boolean flag = empty.isPresent();
		Object empty_ = empty.get();//如果非空则取得对象
		System.out.println(empty_);
	}
	
	/**
	 * ifPresent()可以接受接口段或lambda表达式
	 * 
	 */
	@Test
	public void test_ifPresent() {
		Optional<String> empty = Optional.ofNullable("abc");
		empty.ifPresent((b) -> {System.out.println("The length of the value is: " + b.length());});
		System.out.println("111");
	}
	
	/**
	 * 如果有值则将其返回，否则返回指定的其它值。
	 * orElse
	 */
	@Test
	public void test_orElse() {
		//Optional<String> empty = Optional.ofNullable("abc");
		Optional<String> empty = Optional.ofNullable(null);
		System.out.println(empty.orElse("There is no value present!"));
		//输出：Sanaulla
		System.out.println(empty.orElse("There is some value!"));
	}
	/**
	 * filter
	 * filter个方法通过传入限定条件对Optional实例的值进行过滤。
	 * 如果有值并且满足断言条件返回包含该值的Optional，否则返回空Optional。
	 */
	@Test
	public void test_if() {
		Optional<String> empty = Optional.ofNullable("abc");
		//Optional<String> empty = Optional.ofNullable("abcqweqwe");
		Optional<String> longName = empty.filter((value) -> value.length() > 6);
		boolean flag = longName.isPresent();
		System.out.println(longName.orElse("The name is less than 6 characters"));//输出Sanaulla
	}
}

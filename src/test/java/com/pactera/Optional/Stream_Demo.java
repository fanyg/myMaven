package com.pactera.Optional;

import java.util.List;

import com.google.common.collect.Lists;

public class Stream_Demo {
	//Lists是Guava中的一个工具类
	
	public void cs() {
		
		List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
		
		nums.stream().filter(num -> num != null).count();
	}

	
}
package com.pactera.junit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.common.base.Objects;

public class TestCar {

	@Test
	public void cs() {
		List<Car> list=Arrays.asList(
				new Car("Jeep", "Wrangler", 2011),
				new Car("Jeep", "Comanche", 1990),
				new Car("Dodge", "Avenger", 2010),
				new Car("Buick", "Cascada", 2016),
				new Car("Ford", "Focus", 2012),
				new Car("Chevrolet", "Geo Metro", 1992));
		
		list.stream()
		.filter(a->a.getYear()>2000)
		//.sorted((a,b)->a.getModel().compareTo(b.getModel())) string
		//.sorted(Comparator.comparing(Car::getYear))
		//.sorted((a,b)->Integer.valueOf(a.getYear()).compareTo(Integer.valueOf(b.getYear())))
		.sorted((a,b)->a.getYear()-b.getYear())
		.map(a->a.getModel())
		.collect(Collectors.toList())
		.forEach(a->System.out.println(a));
		
	}
	@Test
	public void cs2() {
		Map<String,Integer> map=new HashMap<String,Integer>();
		String str="http://";
		cs3(str,map);
		cs3(str,map);
	}
	public Map cs3(String str,Map<String,Integer> map) {
/*		if(map.containsKey(str)) {
			map.put(str, map.get(str)+1);
		}else
			map.put(str, 1);*/
/*		for(String str1:map.keySet()) {
			if(str1==str) {
				
			}
		}
		System.out.println(str+"-----"+map.get(str));	*/
		if(map.containsKey(str)) {
//			map.put(str, map.get(str)+1);
			map.merge(str, 1, (oldvalue,value)->oldvalue + value);
		}else
			map.put(str, 1);
		System.out.println(str+"-----"+map.get(str));
		return map;
		
	}
	@Test
	public void cs3() {
		List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");
		 
		List<String> subList = new ArrayList<>();
		for(String name : names) {
		  if(name.length() == 4)
		    subList.add(name);
		}
		 
		StringBuilder namesOfLength4 = new StringBuilder();
		for(int i = 0; i < subList.size() - 1; i++) {
		  namesOfLength4.append(subList.get(i));
		  namesOfLength4.append(", ");
		}
		        
		if(subList.size() > 1)
		  namesOfLength4.append(subList.get(subList.size() - 1));
		 
		System.out.println(namesOfLength4);
	}
	@Test
	public void cs4() {
		
		List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");
		String str = names.stream()
			 .filter(e->e.length()==4)
			 .collect(Collectors.joining(","));
		System.out.println(str);
		
		
		
		for(int i=0;i<=5;i++) {
			int temp=i;
			Thread thread = new Thread(new Runnable() {
				  public void run() {
				    System.out.println(temp);
				  }
				});
		}

		
		/**
		 * JDK 8 还包含多个新函数接口
		 * Consumer<T>
		 * BiConsumer<T, U> 
		 * Function<T, R>
		 * BiFunction<T, U, R>
		 * Supplier<T>
		 * Predicate<T>
		 * Runnable 
		 */
		
		
		
		
		
		
		
	}
}

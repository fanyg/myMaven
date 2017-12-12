package com.pactera.junit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;

/* Stream构造
		1.从 Collection 和数组
			Collection.stream()
			Collection.parallelStream()
			Arrays.stream(T array) or 
			Stream.of()
		2.从 BufferedReader
			java.io.BufferedReader.lines()
		3.静态工厂
			java.util.stream.IntStream.range()
			java.nio.file.Files.walk()
		4.自己构建
			java.util.Spliterator
		5.其它
			Random.ints()
			BitSet.stream()
			Pattern.splitAsStream(java.lang.CharSequence)
			JarFile.stream()
	*/
public class StreamDemo {

	//1.流的构造           从 Collection 和数组
	public void cs() {
		Stream<String> io = Stream.of("a","b","c");
		
		String[] array=new String[] {"a","b","c"};
		Arrays.stream(array);
		
		List list=Arrays.asList(array);
//		List list=new ArrayList<>();
		list.stream();
		
		
		IntStream io2 = IntStream.of(1,2,3);
		IntStream.range(1, 3).forEach(System.out::println);
		
	}
	//2.流的操作
	
	//Intermediate：
	//map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
	
	//Terminal：
	//forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
	
	//Short-circuiting：
	//anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
	@Test
	public void cs1() {

		//1.map 从下面例子可以看出，map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素
		Stream<String> stream = Stream.of("a","b","c");
		String str=stream.map(String::toUpperCase)
			.collect(Collectors.joining(","));
		System.out.println(str);
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		List<Integer> squareNums = nums.stream().
		map(n -> n * n).
		collect(Collectors.toList());
		System.out.println(squareNums);
		
		//一对多映射关系的    flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream 里面已经没有 List 了，都是直接的数字
		Stream<List<Integer>> inputStream = Stream.of(
				 Arrays.asList(1),
				 Arrays.asList(2, 3),
				 Arrays.asList(4, 5, 6)
				 );
		//System.out.println(inputStream.collect(Collectors.toList()));//[[1], [2, 3], [4, 5, 6]]
		Stream<Integer> outputStream = inputStream.
				flatMap((childList) -> childList.stream());
		System.out.println(outputStream.collect(Collectors.toList()));//[1, 2, 3, 4, 5, 6]
		
		//2. forEach
		//3.findFirst  findAny  max/min   返回Optional 
		
		//4.reduce这个方法的主要作用是把 Stream 元素组合起来。它提供一个起始值（种子），然后依照运算规则（BinaryOperator），和前面 Stream 的第一个、第二个、第 n 个元素组合。
		Integer sum = outputStream.reduce(0, (a, b) -> a+b); //或
		Integer sum2 = outputStream.reduce(0, Integer::sum);
		
		// 字符串连接，concat = "ABCD"
				String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat); 
				// 求最小值，minValue = -3.0
				double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min); 
				// 求和，sumValue = 10, 有起始值
				int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
				// 求和，sumValue = 10, 无起始值
				sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
				// 过滤，字符串连接，concat = "ace"
				concat = Stream.of("a", "B", "c", "D", "e", "F").
				 filter(x -> x.compareTo("Z") > 0).
				 reduce("", String::concat);
		//5 sorted
				
		//6 找出最长一行的长度
				BufferedReader br=null;
				try {
					br = new BufferedReader(new FileReader("c:\\SUService.log"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int longest = br.lines()
				 .mapToInt(String::length)
				 .max()
				 .getAsInt();
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(longest);
		//7.Stream.generate
		 Random random = new Random();
		 		int n = random.nextInt();
		 		System.out.println(n);
				
	}
	
	@Test
	public void cs1_1() {
		 Random random = new Random();
	 		//int n = random.nextInt();
	 		//System.out.println(n);
		  Supplier<Integer> rd = random::nextInt;
		  Stream.generate(rd)
		  		.filter(e->e>10)
		  		.filter(e->e<100)
		  		.limit(10)
		  		.forEach(System.out::println);
	
		//Another way
		 // IntStream.generate(() -> (int) (System.nanoTime() % 100)).
		  //limit(10).forEach(System.out::println);
		  
		  System.out.println(System.nanoTime());
	}
	
	
	
	//流转换为其它数据结构
	public void cs2() {
		Stream<String> stream = Stream.of("a","b","c");
		
		String[] strArray = stream.toArray(String[]::new);
		
		List<String> list = stream.collect(Collectors.toList());
		
		 Collection<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
		
		Set set1 = stream.collect(Collectors.toSet());
		Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
		// 3. String
		String str = stream.collect(Collectors.joining()).toString();
		
		
	}
	@Test
	//生成100个随机数
	public void cs100() {
		 Random random = new Random();
	 		//int n = random.nextInt();
	 		//System.out.println(n);
		  Supplier<Integer> rd = random::nextInt;
		  List<Integer> str = Stream.generate(rd)
		  		.filter(e->e>1)
		  		.filter(e->e<100)
		  		.limit(10)
		  		//.forEach(System.out::println);
		  		.collect(Collectors.toList());
		  System.out.println(str);
		  
		  List<Integer> list2=new ArrayList<Integer>();
		  Random random2 = new Random();
		  for(int i=0;i<10;i++) {			  
			  list2.add(random2.nextInt(100)+1);
		  }
		  System.out.println(list2);
	}
	@Test
	public void cs3() throws FileNotFoundException {

		BufferedReader reader=new BufferedReader(new FileReader("c:\\SUService.log"));
		List<String> output = reader.lines()
				.flatMap(line -> Stream.of(line.split("")))
				.filter(word -> word.length() > 0)
				.collect(Collectors.toList());
	}
	
	@Test
	public void cs4() {
		
		//Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));
		
		//Stream.iterate(1, n->n+10).limit(5).forEach(x->System.out.println("111"));
		
		//Stream.generate(new PersonSupplier()).limit(10).forEach(System.out::println);
		
		Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
				 limit(10).
				 collect(Collectors.groupingBy(Person::getAge));
				Iterator it = personGroups.entrySet().iterator();
				while (it.hasNext()) {
				 Map.Entry<Integer, List<Person>> persons = (Map.Entry) it.next();
				 System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
				}
		
		
	}
	
	
	class PersonSupplier  implements Supplier<Person>{

		Random random=new Random();
		int i=1;
		
		@Override
		public Person get() {
			// TODO Auto-generated method stub
			return new Person("Tom"+i++,random.nextInt(8));
		}
		
	}
		
	@Test
	public void cs11() {
		 

		 // 十进制转换为二进制
		 Byte a=1;
		 //a=Byte.MAX_VALUE;
		 System.out.println(a);
	     System.out.println(Integer.toBinaryString(-a));
	     System.out.println(Byte.parseByte("1"));
	     
	}
}

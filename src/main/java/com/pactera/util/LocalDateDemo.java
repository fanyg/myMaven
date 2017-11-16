package com.pactera.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

import org.junit.Test;

/**
 * LocalDate java8特性
 * @author Administrator
 *
 */
public class LocalDateDemo {

	public static void main(String[] args) {
		LocalDateDemo demo=new LocalDateDemo();
		demo.csLocalDate();
	}
	public void csLocalDate() {
		System.out.println(LocalDate.now().toString());//2017-11-16
		
		// 根据年月日取日期：
		LocalDate crischristmas = LocalDate.of(2014, 12, 25); // -> 2014-12-25
		// 根据字符串取：
		LocalDate endOfFeb = LocalDate.parse("2014-02-28"); // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
		LocalDate today=LocalDate.now();
		// 取本月第2天：
		LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); //
		System.out.println(secondDayOfThisMonth);
		
		// 取本月最后一天，再也不用计算是28，29，30还是31：
		LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2017-12-31
		System.out.println(lastDayOfThisMonth);
		// 取本月第1天：
		LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2017-03-01
		System.out.println(firstDayOfThisMonth);
		
		// 取下一天：
		LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(10); // 变成了2018-01-01
		System.out.println(firstDayOf2015);
		// 取2017年1月第一个周一，用Calendar要死掉很多脑细胞：
		LocalDate firstMondayOf2015 = LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2017-01-02
	}
	/**
	 * LocalTime只包含时间，获得当前时间：
	 */
	@Test
	public void csLocalTime() {
		LocalTime now = LocalTime.now(); // 23:11:08.006
		System.out.println(now);
		LocalTime now_ = LocalTime.now().withNano(0); // 23:11:08.006
		System.out.println(now_);
		
		//构造时间：
		LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
		LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
	}
	/**
	 * LocalDateTime只包含时间，获得当前时间：
	 */
	@Test
	public void csLocalDateTime() {
		LocalDateTime now = LocalDateTime.now(); // 23:11:08.006
		System.out.println(now.toString());
		
	//  获取当前年份
		Year year = Year.now();
		System.out.println(year);
		//   从Year获取LocalDate
		LocalDate localDate1 = year.atDay(21);
		System.out.println("localDate1 :" + localDate1);	
		//LocalDate date = LocalDate.now();
		LocalDate date = LocalDate.parse("2016-01-01");
		boolean flag = date.isLeapYear();
		System.out.println(flag);
		
		Date date2=new Date();
		System.out.println(date2);
		
		LocalDateTime dateTime = LocalDateTime.of(2017, 3, 20, 14, 41, 40);
		System.out.println(dateTime);
		
	}
	
}

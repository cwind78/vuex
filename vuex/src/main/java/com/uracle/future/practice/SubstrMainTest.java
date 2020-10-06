package com.uracle.future.practice;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class SubstrMainTest {
	public static void main(String[] args) {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		format.format(d);
		System.out.println(format.format(d));
		
		LocalDate currentDate = LocalDate.now();
		LocalDate targetDate = currentDate.minusMonths(1);
		System.out.println(targetDate.toString());
		targetDate = targetDate.with(TemporalAdjusters.lastDayOfMonth());
		
		System.out.println(currentDate.isAfter(targetDate));
		
		String day = "20191231";
		LocalDate dd = LocalDate.of(Integer.valueOf(day.substring(0, 4)), Integer.valueOf(day.substring(4, 6)), Integer.valueOf(day.substring(6, 8)));
		System.out.println(dd.toString());*/
		
//		String a = null;
//		System.out.println(Long.parseLong(a));
//		float a = 0.0f;
//		System.out.println((Math.floor(a)));
//		System.out.println(String.valueOf(Math.floor(Float.valueOf("0")*0.033)));
//		double a_ = 14.87;
//		double b_ = -22.9;
//		BigDecimal a = new BigDecimal(String.valueOf(a_));
//		BigDecimal b = new BigDecimal(String.valueOf(b_));
//		System.out.println(a.subtract(b));
//		System.out.println(((a.subtract(b)).abs()).subtract(new BigDecimal(0.00)));
//		System.out.println(((a.subtract(b)).abs()).subtract(new BigDecimal(0.00)).doubleValue());
		
		
//		String a = "1234567890";
//		System.out.println(a.substring(3, 4));
		
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		System.out.println(date);
		
		String a= "00989827273";
		a = Integer.valueOf(a).toString();
		System.out.println(a);
	}
}

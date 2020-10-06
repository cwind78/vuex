package com.uracle.future.practice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BigDecimalTest {
	public static void main(String args[]) {
//		BigDecimal a = new BigDecimal(7919074.7999999983);
//		System.out.println(a);
		
//		List<String> a = new ArrayList<String>();
//		a.add("1");
//		a.add("1");
//		a.add("2");
//		a.add("2");
//		a.add("2");
//		a.add("3");
//		a.add("3");
//		a.add("3");
//		a.add("3");
//		
//		String b = String.join(",", a);
//		System.out.println(b);
//		
//		List<String> c = a.stream().distinct().collect(Collectors.toList());
//		
//		String d = String.join(",", c);
//		System.out.println(d);
		
//		TestVariable tv = new TestVariable();
//		tv.test1();
//		tv.test2();
//		
//		
//		String a = "1234567890";
//		System.out.println(a.substring(a.length()-1, a.length()));
		
		double a = 1.23123;
		System.out.println((int)a);
		System.out.println((int)Math.floor(a));
	}
}

class TestVariable {
	int a = 0;
	
	public void test1() {
		a = 1;
		
		System.out.println("local  "+a);
	}
	
	public void test2() {
		System.out.println("global  "+a);
	}
}
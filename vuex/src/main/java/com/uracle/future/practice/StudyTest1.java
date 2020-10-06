package com.uracle.future.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudyTest1 {
	public static void main(String[] args) {
		//���� �ڵ鸵1
		String curr = "";
		String contents = "";
		File file = new File("C:\\Users\\hana\\Documents\\study\\test1.txt");
		
		try (
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr);
			) {
			while ((curr=br.readLine()) != null)
				contents += curr;
			
//			System.out.println(contents);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		contents = "";
		
		//���� �ڵ鸵2
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			) {
			while ((curr=br.readLine()) != null) {
				contents += curr;
			}
			
//			System.out.println(contents);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//����
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("����", "������", 8000));
		books.add(new Book("����", "������", 8000));
		books.add(new Book("����", "������", 8000));
		books.add(new Book("������", "�ڹͽ�", 5000));
		books.add(new Book("�ﱹ��", "�Ҽ�", 30000));
		books.add(new Book("��λ�", "�Ҽ�", 50000));
		books.add(new Book("�ش� ���� ����", "������", 3000));
		
		//��������
		books.sort(Comparator.comparing(Book :: getPrice).reversed());
		for (Book book : books) {
//			System.out.println("å�̸� : "+book.getName()+", ���� : "+book.getPrice());
		}
		
		//��������
		books.sort(Comparator.comparing(Book :: getPrice));
		for (Book book : books) {
//			System.out.println("å�̸� : "+book.getName()+", ���� : "+book.getPrice());
		}
		
		//��¥ ǥ��
		String day = LocalDate.now().toString();
		String dayTime = LocalDateTime.now().toString();
//		System.out.println(day);
//		System.out.println(dayTime);
		
		//��¥ ������
//		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")));
		
		//��¥ �� yyyymmdd ������ �Ľ��� �ȵ�
		String d1 = "2019-01-01";
		String d2 = "2018-01-01";
		
		//System.out.println(Duration.between(LocalDate.parse(d1).atStartOfDay(), LocalDate.parse(d2).atStartOfDay()).toDays());
		//compareTo�� �Ⱓ������� ������� ���� ũ�ų� ���ų� �۰ų� �񱳿����θ� �̿�
		//  �����̸� ��1�� ��2���� ����, ����̸� ŭ, 0�̸� ���� : ��1.compareTo(��2)
//		System.out.println("�Ⱓ : "+LocalDate.parse(d2).compareTo(LocalDate.parse(d1)));
//		System.out.println(d1+"�� "+d2+"���� �ռ� ��¥ : " + LocalDate.parse(d1).isBefore(LocalDate.parse(d2)));
//		System.out.println(d1+"�� "+d2+"���� �ڼ� ��¥ : " + LocalDate.parse(d2).isAfter(LocalDate.parse(d1)));
//		System.out.println(d1+"�� "+d2+"�� ���� : " + LocalDate.parse(d2).isEqual(LocalDate.parse(d1)));
		//��¥ ��������
		//1��
//		System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
		//����
//		System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
		//1�� ���ϱ�
//		System.out.println(LocalDate.now().plusMonths(1));
		
		
		
		//2�ڸ� ���� ����
		float randomNum = (float) Math.random();
//		System.out.println(randomNum + ", " + (int)(randomNum*100));
		
		
		List<String> strs = new ArrayList<String>();
		strs.add("202001011231");
		strs.add("202001011321");
		strs.add("202001010511");
		strs.add("202001010713");
		strs.add("201912311133");
		
		Test1 test1 = new Test1();
		test1.setTest1(strs);
		Collections.sort(test1.getTest1());
		for (String str : test1.getTest1()) {
			System.out.println(str);
		}
	}
}

package com.uracle.future.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookTest {
	public static void main(String[] args) {
		List<Book> books = Arrays.asList(
			new Book("ȩ���� ���Ǽ�", "ö��", 50000l),
			new Book("����Ŭ �������� �����ں����� ����", "����", 30000l),
			new Book("�̵��÷α�", "��ȸ", 30000l),
			new Book("�̱��� ���尳��", "����", 20000l),
			new Book("��ü�� ���� ��ȭ", "����", 30000l)
		);
		
		Stream<Book> booksExpen = books.stream()
				.filter(book-> book.getPrice()>20000l);
		Set<Book> booksExpenSet = booksExpen.collect(Collectors.toSet());
		  //.forEach(book -> System.out.println(book.getPrice()));
		  
		for (Book book : booksExpenSet) {
			System.out.println(book.getName() + ", " + book.getPrice());
		}
		
		books.stream()
			.filter(book -> book.getType().equals("����"))
			.forEach(book -> System.out.println(book.getName() + ", " + book.getPrice()));
	}
}

package com.uracle.future.practice;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DisTest {
	public static void main(String[] args) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("book1", "1", 10000));
		books.add(new Book("book2", "1", 10000));
		books.add(new Book("book3", "2", 20000));
		books.add(new Book("book4", "1", 10000));
		books.add(new Book("book5", "3", 30000));
		books.add(new Book("book6", "1", 50000));
		books.add(new Book("book7", "3", 20000));
		books.add(new Book("book8", "2", 10000));
		
		
		//books.sort(Comparator.comparing(Book::getType).reversed());
		
		books.sort(Comparator.comparing(Book::getType));
		for (Book book : books) {
			System.out.println("name : "+book.getName()+
							   ", type : "+book.getType()+
							   ", price : "+book.getPrice()
			);
		}
		
		
		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))+String.valueOf((int)(Math.random()*10)));
	}
}

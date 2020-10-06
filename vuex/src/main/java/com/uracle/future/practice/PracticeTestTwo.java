package com.uracle.future.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PracticeTestTwo {
	public static void main(String[] args) throws Exception {
		/*String date = "20191010";
		System.out.println(date.substring(0, 4));*/
		String line = "";
		String downloadPath = "./src/main/resources/example.txt";
		File file = new File(downloadPath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			List<String> data = getDataStreamList(line);
			System.out.println(line);
			if (data != null && data.size() > 0) {
				for (String word : data) {
					System.out.println(word);
				}
			}
		}
		
		br.close();
	}
	
	public static List<String> getDataStreamList(String data) {
		List<String> list = new ArrayList<String>();
		list.add(data.substring(0, 11));
		list.add(data.substring(11, 21));
		list.add(data.substring(21, 31));
		list.add(data.substring(31, 41));
		list.add(data.substring(41, 51));
		
		return list;
	}
}

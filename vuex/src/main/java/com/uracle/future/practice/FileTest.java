package com.uracle.future.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class FileTest {
	public static void main(String[] args) {
		try {
			String line = "";
			File directory = new File("C:\\vccTemp\\");
			if (!directory.isDirectory()) {
				System.out.println("��ΰ� �������� �ʽ��ϴ�");
			} else {
				File[] files = directory.listFiles();
				List<File> fileList = Arrays.asList(files);
				for (File f : fileList) {
					if (!f.isDirectory()) {
						BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f.getAbsolutePath())));
						while ((line = br.readLine()) != null) {
							System.out.println(line);
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

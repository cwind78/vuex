package com.uracle.future.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileQueryTest {
	public static void main(String[] args) {
		String str;
		StringBuffer qry = new StringBuffer();
		String sql = "";
		String type = "";
		int value = -1;
		int result = -1;
		String title = "";
		StringBuffer write = new StringBuffer();
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Temp\\test.txt"))));
				FileOutputStream fos = new FileOutputStream(new File("C:\\temp\\Result\\result_"+date))
				) {
			while ((str = br.readLine()) != null) {
				if (str.contains("!@#")) {
					if (qry.length() > 0) {
						sql = qry.toString();
						
						//���� ���� ���
						result = 0;
						
						//���� ����� ���Ͽ��� �Ѱܹ��� �񱳰����� üũ
						write.append("\n��� ::: "+checkResult(type, value, result));
						
						//���� ���� �ʱ�ȭ
						qry.setLength(0);
					}
					
					//������� ���Ͽ��� �Ѱܹ��� �񱳹�, �� ���(int), ���� ����
					type = str.substring(str.length()-2, str.length()-1);
					value = Integer.valueOf(str.substring(str.length()-1, str.length()));
					title = str.substring(0, str.indexOf("!@#"));
					
					//�α� ���Ͽ� �� ����
					//System.out.println(sql+type+value+title);
					write.append("\n==============================================================================");
					write.append("\n�˻� ��� ::: "+title);
					write.append("\n�˻��� ::: ��� "+type+value+" = ����");
				} else {
					qry.append(str+"\n");
				}
			}
			
			if (!sql.isEmpty()) {
				//System.out.println(qry.toString());
				result = 1;
				write.append("\n��� ::: "+checkResult(type, value, result));
			}
			
			if (!write.toString().isEmpty()) {
				fos.write(write.toString().getBytes());
				fos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static boolean checkResult(String type, int value, int count) {
		boolean valid = true;
		
		switch (type) {
		case "=" :
			if (value != count) {
				valid = valid && false;
			}
			break;
		case ">" :
			if (value <= count) {
				valid = valid && false;
			}
			break;
		case "<" :
			if (value >= count) {
				valid = valid && false;
			}
			break;
		}
		
		//System.out.println(valid);
		return valid;
	}
}

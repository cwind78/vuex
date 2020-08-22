package com.uracle.future.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class SecurityBase64 {
	public String getEncryptBase64(String text) {
		try {
			byte[] targetBytes = text.getBytes();
			Encoder encoder = Base64.getEncoder(); 
			byte[] encodedBytes = encoder.encode(targetBytes);
			
			
	//		System.out.println("인코딩 전 : " + text); System.out.println("인코딩 text : " + new
	//		String(encodedBytes));
			return new String(encodedBytes);
		} catch (Exception e) {
			return null;
		}
		 
		
	}
	
	public String getDecryptBase64(String text) {
		try {
			Decoder decoder = Base64.getDecoder(); 
			byte[] decodedBytes = decoder.decode(text); 
			
	//		System.out.println("디코딩 text : " + new String(decodedBytes));
			
			return new String(decodedBytes);
		} catch (Exception e) {
			return null;
		}
	}
}

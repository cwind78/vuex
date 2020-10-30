package com.uracle.future.practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import com.jcraft.jsch.SftpException;

public class SftpTest {
	public static void main(String[] args) {
		SftpTest test = new SftpTest();
		test.sftpProcess();
	}
	
	public void sftpProcess() {
		String ftpIp = "192.168.85.204";
		String ftpPort = "2222";
		String ftpId = "lotus78";
		String ftpPwd = "0911";
		int read = 0;
		byte[] buffer = new byte[1024];
		
//		JSch jSch = new JSch();
//
//		try {
//			Session session = jSch.getSession(ftpId, ftpIp, Integer.parseInt(ftpPort));
//			session.setPassword(ftpPwd);
//			
//			Properties config = new Properties();
//			config.put("StrictHostKeyChecking", "no");
//			session.setConfig(config);
//			
//			session.connect();
//			
//			Channel channel = session.openChannel("sftp");
//			channel.connect();
//			
//			ChannelSftp channelSftp = (ChannelSftp) channel;
//			channelSftp.cd("request");
//			
//			@SuppressWarnings("unchecked")
//			List<ChannelSftp.LsEntry> fileList = channelSftp.ls("*");
//			for (ChannelSftp.LsEntry entry : fileList) {
//				File file = new File("C:\\vccTemp\\"+entry.getFilename());
//				
//				try (
//						BufferedInputStream bis = new BufferedInputStream(channelSftp.get(entry.getFilename()));
//						FileOutputStream fos = new FileOutputStream(file); 
//						BufferedOutputStream bos = new BufferedOutputStream(fos);
//						FileReader fr = new FileReader(file);
//						BufferedReader buff = new BufferedReader(fr);
//				) {
//					while ((read = bis.read(buffer)) > 0) {
//						bos.write(buffer, 0, read);
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//				channelSftp.rm(entry.getFilename());
//			}
//			
//			channelSftp.exit();
//			channel.disconnect();
//			session.disconnect();
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (JSchException e) {
//			e.printStackTrace();
//		} catch (SftpException e) {
//			e.printStackTrace();
//		}
	}
}

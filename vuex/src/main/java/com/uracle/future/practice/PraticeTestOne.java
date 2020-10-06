package com.uracle.future.practice;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PraticeTestOne {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("CDF30_PH11_Korea.xml");
		document.getDocumentElement().normalize();
		
		
		// root ���ϱ�
		Element root = document.getDocumentElement();
		
		// root�� �Ӽ�
		System.out.println("class name: " + root.getAttribute("name"));
		
		//NodeList childeren = root.getChildNodes(); // �ڽ� ��� ��� get
		NodeList childeren = document.getElementsByTagName("AccountEntity");
		for(int i = 0; i < childeren.getLength(); i++){
			Node node = childeren.item(i);
			Element element = (Element)node;
			
			System.out.println(getTagValue("AlternateAccountNumber", element));
		}
	}
	
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}
}

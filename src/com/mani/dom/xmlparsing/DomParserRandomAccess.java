package com.mani.dom.xmlparsing;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserRandomAccess {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("src\\com\\mani\\resources\\employees2.xml"));
			NodeList nodeList = doc.getElementsByTagName("employee");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node employeeNode = nodeList.item(i);
				System.out.println("Element:" + employeeNode.getNodeName());
				if (employeeNode.hasAttributes()) {
					NamedNodeMap attributes = employeeNode.getAttributes();
					for (int k = 0; k < attributes.getLength(); k++) {
						Node attribute = attributes.item(k);
						System.out.println(attribute.getNodeName() + "=" + attribute.getNodeValue());
					}
				}
				if (employeeNode.hasChildNodes()) {
					System.out.println(employeeNode.getNodeName() + "Child Elements");
					NodeList employeeChildNodes = employeeNode.getChildNodes();
					for (int j = 0; j < employeeChildNodes.getLength(); j++) {
						Node childNode = employeeChildNodes.item(j);
						if (childNode.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println(childNode.getNodeName() + "--->" + childNode.getTextContent());
						}
					}

				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {

			e.printStackTrace();
		}

	}

}

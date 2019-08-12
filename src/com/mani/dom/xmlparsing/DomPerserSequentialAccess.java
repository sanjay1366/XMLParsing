package com.mani.dom.xmlparsing;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomPerserSequentialAccess {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			File file = new File("src\\com\\mani\\resources\\employees.xml");
			Document document = db.parse(file);
			Element rootElement = document.getDocumentElement();
			System.out.println(rootElement.getNodeName());
			if (rootElement.hasChildNodes()) {
				NodeList childNodes = rootElement.getChildNodes();
				for (int i = 0; i < childNodes.getLength(); i++) {
					Node node = childNodes.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println(node.getNodeName() + "--->" + node.getTextContent());
					}
				}
			}

		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}

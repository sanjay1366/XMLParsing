package com.mani.sax.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class SaxParserExample {
	/*
	 * SAX (Simple Api For XML) is an event-based parser for xml documents.Unlike
	 * ADOM Parser SAX Parser creates np parse tree. It is used to cperform only
	 * read operations.
	 */
	/*
	 * Steps to create SAX parser
	 * 
	 * 1)create SAXParserFactory object using newInstance() 
	 * 2)create SAXParser object using newSAXParser() method of SAXParserFactory Class
	 *--> SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
     *--> SAXParser saxParser = saxParserFactory.newSAXParser();
	 * 3)Create a CustomHandler class for handle the events.
	 * -->MyHandler handler = new MyHandler();
	 * 4)parse the xml.
	 * -->parse(InputStream is,DefaultHandler dh)throwsIOEx,SAXEx.
	 * 
	 */
	public static void main(String[] args) {
		SAXParserFactory saxFactory=SAXParserFactory.newInstance();
		try {
			SAXParser saxPerser=saxFactory.newSAXParser();
			MyAccountHandler myAccontHandler=new MyAccountHandler();
			try {
				saxPerser.parse(new File("src\\com\\mani\\resources\\Account.xml"),myAccontHandler);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
			
			e.printStackTrace();
		}
		

	}

}

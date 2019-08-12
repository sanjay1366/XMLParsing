package com.mani.sax.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyAccountHandler extends DefaultHandler {
	boolean id;
	boolean name;
	boolean amount;
	boolean bank;
	boolean account;

	@Override
	public void startDocument() throws SAXException {
		System.out.println("document started");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("document ended");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("start element name-->"+qName);

		if (qName.equals("account")) {
			account = true;
			System.out.println("Account type-->" + attributes.getValue("type"));
		} else if (qName.equals("id")) {
			id = true;
		} else if (qName.equals("name")) {
			name = true;
		} else if (qName.equals("amount")) {
			amount = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (id) {
			System.out.println("AccId:-->" + new String(ch, start, length));
			id = false;
		}
		if (name) {
			System.out.println("name:-->" + new String(ch, start, length));
			name = false;
		}
		if (amount) {
			System.out.println("amount:-->" + new String(ch, start, length));
			amount = false;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("end element name--->"+qName);
	}

}

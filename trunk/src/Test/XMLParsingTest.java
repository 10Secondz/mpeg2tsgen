package Test;

import java.io.StringReader;
import org.xml.sax.*;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import API.SITableFactory;

public class XMLParsingTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		API.PSI.PAT table = SITableFactory.createPAT(15, 0xABC);
		API.PSI.PATProgram program1 = SITableFactory.createPATProgram(0xC0, 0xD0);
		API.PSI.PATProgram program2 = SITableFactory.createPATProgram(0xE0, 0xF0);
		table.addProgram(program1);
		table.addProgram(program2);
		
		table.toXMLString(0);
		
		try {
			XMLReader parser = XMLReaderFactory.createXMLReader();
			org.xml.sax.ContentHandler handler 
		       = new TestHandler();
			parser.setContentHandler(handler);
			InputSource inputSrc = new InputSource(new StringReader(table.toXMLString(0)));
			parser.parse(inputSrc);
		} catch (Exception e) { e.printStackTrace(); } 
	}
}

class TestHandler extends DefaultHandler
{
	public void startElement(String namespaceURI, String localName,
			String qualifiedName, Attributes atts) throws SAXException {
		System.out.println("startElement: "+namespaceURI+", "+localName+", "+
				qualifiedName+", "+atts);
	}

	public void endElement(String namespaceURI, String localName,
			String qualifiedName) throws SAXException {
		System.out.println("endElement: "+namespaceURI+", "+localName+", "+
				qualifiedName);
	}

	public void characters(char[] ch, int start, int length)
		throws SAXException {
		System.out.println("characters: "+ch+", "+start+", "+
				length);
	}
}

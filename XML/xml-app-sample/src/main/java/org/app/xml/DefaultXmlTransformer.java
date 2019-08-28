package org.app.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DefaultXmlTransformer implements XmlTransformer {


    public String convertToXml(Person p) {
        try(InputStream in = getClass().getResourceAsStream("/xml_template.txt");){
             byte[] data = new byte[in.available()];
             in.read(data);
             String xmlTemplate = new String(data);
             return String.format(xmlTemplate, p.getName(), p.getAge());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person convertFromXml(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try(ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes())) {
            SAXParser parser = factory.newSAXParser();
            Person p = new Person();

            parser.parse(in, new DefaultHandler(){
                private String currentTag;

                @Override
                public void startDocument() throws SAXException {
                    System.out.println("startDocument()");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("startElement: "+qName);
                    currentTag = qName;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch, start, length);
                    if(!value.trim().isEmpty()) {


                        if ("name".equals(currentTag)) {
                            p.setName(value.trim());
                        }
                        if ("age".equals(currentTag)) {
                            p.setAge(Integer.parseInt(value.trim()));
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("endElement: "+qName);
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("endDocument()");
                }
            });
            return p;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

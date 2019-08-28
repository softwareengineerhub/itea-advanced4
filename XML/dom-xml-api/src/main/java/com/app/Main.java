package com.app;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        InputStream in = Main.class.getResourceAsStream("/pom.xml");
        Document document = parser.parse(in);
        NodeList children = document.getChildNodes();
        System.out.println(children.getLength());
        for(int i=0;i<children.getLength();i++){
            Node node = children.item(i);
            String localName = node.getLocalName();
            String value = node.getNodeValue();
            System.out.println("localName: "+localName);
            System.out.println("value: "+value);
            NodeList subChildren = node.getChildNodes();
            for(int j=0;j<subChildren.getLength();j++){
                Node subNode = subChildren.item(j);
                String subLocalName = subNode.getLocalName();
                String subValue = subNode.getTextContent();
                System.out.println("subLocalName: "+subLocalName);
                System.out.println("subValue: "+subValue);
            }

        }

    }
}

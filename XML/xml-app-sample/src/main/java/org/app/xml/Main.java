package org.app.xml;

public class Main {

    public static void main(String[] args) {
        XmlTransformer xmlTransformer = new DefaultXmlTransformer();
        Person p = new Person(45, "Piter");
        String xml = xmlTransformer.convertToXml(p);
        System.out.println(xml);
        System.out.println("----------------------------");
        p = xmlTransformer.convertFromXml(xml);
        System.out.println("----------------------------");
        System.out.println(p);
    }
}

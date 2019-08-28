package org.app.xml;

public interface XmlTransformer {

    public String convertToXml(Person p);

    public Person convertFromXml(String xml);

}

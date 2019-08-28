package org.app.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class MyXmlParser {

    public String toXml(Car car) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            JAXBContext ctx = JAXBContext.newInstance(Car.class);
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.marshal(car, out);
            return new String(out.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Car fromXml(String xml) {
        try (ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes())) {
            JAXBContext ctx = JAXBContext.newInstance(Car.class);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            return (Car) unmarshaller.unmarshal(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

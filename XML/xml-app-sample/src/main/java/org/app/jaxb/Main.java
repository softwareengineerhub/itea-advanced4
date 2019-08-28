package org.app.jaxb;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        car.setAge(1);
        car.setName("Car1");
        Engine engine = new Engine();
        engine.setVersion("V1");
        engine.setVolume(2);
        car.setEngine(engine);

        MyXmlParser myXmlParser = new MyXmlParser();
        String xml = myXmlParser.toXml(car);
        System.out.println(xml);
        car = myXmlParser.fromXml(xml);
        System.out.println(car);
    }
}

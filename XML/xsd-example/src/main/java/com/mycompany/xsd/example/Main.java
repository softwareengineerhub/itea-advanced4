package com.mycompany.xsd.example;

import generated.Note;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {

    public static void main(String[] args) throws JAXBException {

        Note note = new Note();
        note.setBody("bodyValue");
        note.setFrom("from");
        note.setHeading("hhh");
        note.setTo("To");

        JAXBContext ctx = JAXBContext.newInstance(Note.class);
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.marshal(note, System.out);


    }
}

package com.app.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
       Person p = new Person();
       //p.name="qqq";
        p.setAge(1);
        p.setName("Name1");
        System.out.println(p);
        System.out.println("----------------------");
        Class cl=Class.forName("com.app.model.Person");
        Object object = cl.newInstance();
        Object object2 = cl.newInstance();

        /*Person person2 = (Person) cl.newInstance();
        Person person = null;
        if(object instanceof  Person){
            person = (Person) object;
        }
        System.out.println(person);
        System.out.println(person2);*/

        Field nameField = cl.getDeclaredField("name");
        Field ageField = cl.getDeclaredField("age");
        nameField.setAccessible(true);
        ageField.setAccessible(true);


        //object.name="Name1";
        nameField.set(object, "Name1");
        ageField.set(object, 1);

     //object2.name="Name2";
        nameField.set(object2, "Name1");
        ageField.set(object2, 2);

     System.out.println(object);
     System.out.println(object2);

     System.out.println("---------------------------");
     //cl.getDeclaredConstructors();
     Constructor constructor = cl.getDeclaredConstructor(String.class, int.class);
     //new Person("", 1);
     Object object3 = constructor.newInstance("Name3", 3);
     Object object4 = constructor.newInstance("Name4", 4);
     System.out.println(object3);
     System.out.println(object4);

     System.out.println("-------------Methods------------");
     System.out.println("-------------doAction()------------");
     Method m = cl.getDeclaredMethod("doAction");
     m.invoke(object3);
     m.invoke(object4);
     System.out.println("-------------doAction(String)------------");
     Method m2 = cl.getDeclaredMethod("doAction", String.class);
     m2.invoke(object3, "Hello");

    }
}

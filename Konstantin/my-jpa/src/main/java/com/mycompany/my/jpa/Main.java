/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_my-jpa_jar_1.0-SNAPSHOTPU");
        EntityManager em = factory.createEntityManager();        
        em.getTransaction().begin();
        
        User user = new User();
        user.setName("User1");
        
        em.persist(user);
        
        em.getTransaction().commit();
        
    }
    
}

import entity.User;

import org.hibernate.Session;
import utils.HibernateSessionFactory;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        User user = new User();
        user.setNamik("Borya");

        session.save(user);
        session.getTransaction().commit();

        session.close();
    }

}
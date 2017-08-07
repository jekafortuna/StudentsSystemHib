package ua.kpi.StudentsSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.kpi.StudentsSystem.entity.Student;

/**
 * Created by Evgeniy on 31.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        /*
        Student student = new Student();
        student.setFirstName("John");
        student.setLastName("Terry");
        student.setAge(30);

        session.save(student); */

        Student student = session.get(Student.class, 2);
        System.out.println(student);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}

package ua.kpi.StudentsSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.kpi.StudentsSystem.Reports.ExamResult;
import ua.kpi.StudentsSystem.Reports.Reports;

import java.util.List;

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

        session.save(student);
        */

        /*
        Student student = session.get(Student.class, 1);
        Set<Exam> exams = student.getExams();
        System.out.println(student);
        */

        /*
        Query query = session.createQuery("from Student ");
        List<Student> students = query.getResultList();
        */

        Reports reports = new Reports();
        List<ExamResult> results = reports.getExamResults("Steven", "Gerrard", session);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}

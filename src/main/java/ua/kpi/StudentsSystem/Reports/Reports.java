package ua.kpi.StudentsSystem.Reports;

import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Evgeniy on 08.08.2017.
 * HQL query
 */
public class Reports {
    public List<ExamResult> getExamResults(String firstName, String lastName, Session session){
        String query = "select new ua.kpi.StudentsSystem.Reports.ExamResult(s.lastName, sj.name, e.grade) " +
                       "from Exam e, Student s, Subject sj " +
                       "where e.student.id = s.id and e.subject.id = sj.id " +
                       "and s.firstName = :firstName and s.lastName = :lastName";

        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("firstName", firstName);
        hibernateQuery.setParameter("lastName", lastName);

        return hibernateQuery.getResultList();
    }

    public List<ExamResult> getExamResultsSimple(String firstName, String lastName, Session session){
        String query = "select new ua.kpi.StudentsSystem.Reports.ExamResult(e.student.lastName, e.subject.name, e.grade) " +
                "from Exam e " +
                "where e.student.firstName = :firstName and e.student.lastName = :lastName";

        Query hibernateQuery = session.createQuery(query);
        hibernateQuery.setParameter("firstName", firstName);
        hibernateQuery.setParameter("lastName", lastName);

        return hibernateQuery.getResultList();
    }
}

package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.EstimationsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Repository
public class EstimationsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Возвращает все оценки ученика по всем предметам в дневник
     */
    @SuppressWarnings("unchecked")
    public List<EstimationsEntity> getEstimationsForDiary(Integer userId, Integer half, Integer year) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(EstimationsEntity.class);
        return cr.add(Restrictions.eq("semester", half))
                .add(Restrictions.eq("year", year))
                .createCriteria("studentObjectTeacherByInfoId", JoinType.INNER_JOIN)
                .add(Restrictions.eq("studentsByStudentId.id", userId))
                .list();

    }

    /*
     * Отображает журнал для преподавателя
     */
    @SuppressWarnings("unchecked")
    public List<EstimationsEntity> getEstimationsForJournal(Integer teacherId, Integer objectId, String cl, Integer half, Integer year) {
        Session session = null;
        List<EstimationsEntity> list = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from EstimationsEntity as est where " +
                    "est.semester=:half and " +
                    "est.year=:year and " +
                    "est.studentObjectTeacherByInfoId.studentsByStudentId.clazz=:cl and " +
                    "est.studentObjectTeacherByInfoId.teacherObjectByTeacherObjectId.teachersByTeacherId.id=:teacherId and " +
                    "est.studentObjectTeacherByInfoId.teacherObjectByTeacherObjectId.objectsEntity.id=:objectId " +
                    "order by est.studentObjectTeacherByInfoId.studentsByStudentId.lastName");
            query.setParameter("teacherId", teacherId);
            query.setParameter("cl", cl);
            query.setParameter("half", half);
            query.setParameter("year", year);
            query.setParameter("objectId", objectId);
            list = query.list();
        } catch (Exception e) {
            System.err.println("Error in getEstimationsForJournal(): " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    /*
     * Возвращает список классов, в которых ведет препод с данным id
     */
    @SuppressWarnings("unchecked")
    public List<String> getClasses(Integer teacherId) {
        List<String> classes = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery(" from EstimationsEntity as est where " +
                    "est.studentObjectTeacherByInfoId.teacherObjectByTeacherObjectId.teachersByTeacherId.id=:teacherId");
            query.setParameter("teacherId", teacherId);
            List<EstimationsEntity> list = query.list();
            for (EstimationsEntity element : list) {
                String clazz = element.getStudentObjectTeacherByInfoId().getStudentsByStudentId().getClazz();
                if (!classes.contains(clazz))
                    classes.add(clazz);
            }
        } catch (Exception e) {
            System.err.println("Error in getClasses(): " + e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return classes;
    }

    /*
     * Добавление оценки в журнал
     */
    public void addEstimate(Integer estimate, Integer studentId, Integer objectId, Integer half, Integer year) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(EstimationsEntity.class);
        crit.add(Restrictions.eq("semester", half))
                .add(Restrictions.eq("year", year));
        crit.createAlias("studentObjectTeacherByInfoId", "student_object_teacher");
        crit.createAlias("student_object_teacher.studentsByStudentId", "student");
        crit.createAlias("student_object_teacher.teacherObjectByTeacherObjectId", "teacher_object");
        crit.createAlias("teacher_object.objectsEntity", "objects");
        crit.add(Restrictions.eq("student.id", studentId));
        crit.add(Restrictions.eq("objects.id", objectId));
        EstimationsEntity entity = (EstimationsEntity) crit.uniqueResult();
        Integer getEstimation[] = {entity.getEstimate0(), entity.getEstimate1(), entity.getEstimate2(), entity.getEstimate3(),
                entity.getEstimate4(), entity.getEstimate5(), entity.getEstimate6(), entity.getEstimate7(),
                entity.getEstimate8(), entity.getEstimate9()};
        for (int i = 0; i < 10; i++) {
            if (getEstimation[i] == null) {
                if (i == 0) entity.setEstimate0(estimate);
                if (i == 1) entity.setEstimate1(estimate);
                if (i == 2) entity.setEstimate2(estimate);
                if (i == 3) entity.setEstimate3(estimate);
                if (i == 4) entity.setEstimate4(estimate);
                if (i == 5) entity.setEstimate5(estimate);
                if (i == 6) entity.setEstimate6(estimate);
                if (i == 7) entity.setEstimate7(estimate);
                if (i == 8) entity.setEstimate8(estimate);
                if (i == 9) entity.setEstimate9(estimate);
                break;
            }
        }
    }
}

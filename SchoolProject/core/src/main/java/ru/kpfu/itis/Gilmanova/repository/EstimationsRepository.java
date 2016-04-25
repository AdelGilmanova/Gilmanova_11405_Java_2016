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
import ru.kpfu.itis.Gilmanova.model.StudentObjectTeacherEntity;

import java.util.ArrayList;
import java.util.LinkedList;
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
        List<EstimationsEntity> list = new LinkedList<>();
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
            Query query = session.createQuery(" from StudentObjectTeacherEntity as sot where " +
                    "sot.teacherObjectByTeacherObjectId.teachersByTeacherId.id=:teacherId");
            query.setParameter("teacherId", teacherId);
            List<StudentObjectTeacherEntity> list = query.list();
            for (StudentObjectTeacherEntity element : list) {
                String clazz = element.getStudentsByStudentId().getClass_id().getClazz();
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
    @SuppressWarnings("unchecked")
    public void addEstimate(Integer estimate, Integer studentId, Integer objectId,
                            Integer teacherId, Integer half, Integer year) {
        StudentObjectTeacherEntity values = getInfo(studentId, teacherId, objectId);
        EstimationsEntity estimationsEntity = new EstimationsEntity(values, estimate, half, year);
        sessionFactory.getCurrentSession().save(estimationsEntity);

    }

    /*
     * Возвращает сущность студент-преподаватель-предмет
     */
    public StudentObjectTeacherEntity getInfo(Integer studentId, Integer teacherId, Integer objectId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentObjectTeacherEntity.class);
        crit.createAlias("studentsByStudentId", "student");
        crit.add(Restrictions.eq("student.id", studentId));
        crit.createAlias("teacherObjectByTeacherObjectId", "teacher_object");
        crit.createAlias("teacher_object.teachersByTeacherId", "teacher");
        crit.createAlias("teacher_object.objectsEntity", "object");
        crit.add(Restrictions.eq("teacher.id", teacherId));
        crit.add(Restrictions.eq("object.id", objectId));
        return (StudentObjectTeacherEntity) crit.uniqueResult();
    }
}

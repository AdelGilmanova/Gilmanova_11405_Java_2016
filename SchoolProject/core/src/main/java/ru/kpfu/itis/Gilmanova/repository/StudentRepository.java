package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;

import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Возвращает студента по его id
     */
    public StudentsEntity getStudent(Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        return (StudentsEntity) crit.add(Restrictions.eq("id", userId)).uniqueResult();
    }

    /*
     * Возвращает список учеников в журнал
     */
    @SuppressWarnings("unchecked")
    public List<StudentsEntity> getStudents(Integer teacherId, Integer objectId, String cl) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.createAlias("student_object_teacher", "student_object_teacher");
        crit.createAlias("student_object_teacher.teacherObjectByTeacherObjectId", "teacher_object");
        crit.createAlias("teacher_object.objectsEntity", "objects");
        crit.add(Restrictions.eq("objects.id", objectId));
        crit.createAlias("teacher_object.teachersByTeacherId", "teachers");
        crit.add(Restrictions.eq("teachers.id", teacherId));
        crit.createAlias("student_object_teacher.studentsByStudentId", "student");
        crit.add(Restrictions.eq("student.clazz", cl));
        return crit.list();
    }

    /*
     * Возвращает id ученика по его имени
     */
    public Integer getStudentId(String lastName, String firstName) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.add(Restrictions.eq("lastName", lastName))
                .add(Restrictions.eq("firstName", firstName));
        return ((StudentsEntity) crit.uniqueResult()).getId();
    }

    /*
     * Возвращает список учащихся в таблицу админа
     */
    @SuppressWarnings("unchecked")
    public List<StudentsEntity> getAllStudents() {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        return crit.list();
    }

    /*
     * Возвращает отфильтрованных учащихся по запросу админа
     */
    @SuppressWarnings("unchecked")
    public List<StudentsEntity> getStudentByClass(Integer classId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.createAlias("class_id", "class").add(Restrictions.eq("class.id", classId));
        return crit.list();
    }

    /*
     * Возвращает отфильтрованных по имени учащихся по запросу админа
     */
    @SuppressWarnings("unchecked")
    public List<StudentsEntity> getStudentByName(String name) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.add(Restrictions.or(Restrictions.like("firstName", "%" + name + "%"), Restrictions.like("lastName", "%" + name + "%")));
        return crit.list();
    }
}

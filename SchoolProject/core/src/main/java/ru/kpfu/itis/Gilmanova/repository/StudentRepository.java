package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
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
     * Возвращает студента по userId
     */
    public StudentsEntity getStudentByUserId(Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.add(Restrictions.eq("usersEntity.id", userId));
        return (StudentsEntity) crit.uniqueResult();
    }

    /*
     * Возвращает студента по его id
     */
    public StudentsEntity getStudent(Integer studentId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.add(Restrictions.eq("id", studentId));
        return (StudentsEntity) crit.uniqueResult();
    }

    /*
     * Возвращает список учащихся в таблицу админа
     */
    @SuppressWarnings("unchecked")
    public List<StudentsEntity> getAllStudents() {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.addOrder(org.hibernate.criterion.Order.asc("id"));
        return crit.list();
    }

    /*
     * Возвращает отфильтрованных учащихся по запросу админа
     */
    @SuppressWarnings("unchecked")
    public List<StudentsEntity> getStudentByClass(Integer classId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.createAlias("class_id", "class");
        crit.add(Restrictions.eq("class.id", classId));
        crit.addOrder(org.hibernate.criterion.Order.asc("id"));
        return crit.list();
    }

    /*
     * Возвращает отфильтрованных по имени учащихся по запросу админа
     */
    @SuppressWarnings("unchecked")
    public List<StudentsEntity> getStudentByName(String name) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        crit.add(Restrictions.or(Restrictions.like("firstName", "%" + name + "%"), Restrictions.like("lastName", "%" + name + "%")));
        crit.addOrder(org.hibernate.criterion.Order.asc("id"));
        return crit.list();
    }

    /*
     * Блокировка студента админом
     */
    public void blockStudent(Integer studentId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        StudentsEntity student = (StudentsEntity) crit.add(Restrictions.eq("id", studentId)).uniqueResult();
        student.getUsersEntity().setEnable(false);
        sessionFactory.getCurrentSession().update(student);
    }

    /*
     * Снятие блокировки студента админом
     */
    public void unblockStudent(Integer studentId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        StudentsEntity student = (StudentsEntity) crit.add(Restrictions.eq("id", studentId)).uniqueResult();
        student.getUsersEntity().setEnable(true);
        sessionFactory.getCurrentSession().update(student);
    }

    /*
     * Редактирование инфы студента
     */
    public void changedStudentInfo(Integer studentId, String lastName, String firstName, Integer classId) {
        Criteria studentCrit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        StudentsEntity student = (StudentsEntity) studentCrit.add(Restrictions.eq("id", studentId)).uniqueResult();
        student.setLastName(lastName);
        student.setFirstName(firstName);
        Criteria classCrit = sessionFactory.getCurrentSession().createCriteria(ClassesEntity.class);
        ClassesEntity classesEntity = (ClassesEntity) classCrit.add(Restrictions.eq("id", classId)).uniqueResult();
        student.setClass_id(classesEntity);
        sessionFactory.getCurrentSession().update(student);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

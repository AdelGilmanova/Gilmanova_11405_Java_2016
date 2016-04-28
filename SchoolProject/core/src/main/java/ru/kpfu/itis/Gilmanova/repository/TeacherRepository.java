package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;

import java.util.List;

/**
 * Created by Adel on 17.04.2016.
 */
@Repository
public class TeacherRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Возвращает учителя по его id
     */
    public TeachersEntity getTeacher(Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        return (TeachersEntity) crit.add(Restrictions.eq("id", userId)).uniqueResult();
    }

    /*
     * Добавление фото (не работает)
     */
    public void addPhoto(String filePath, Integer userId) {
        TeachersEntity teachersEntity = getTeacher(userId);
        teachersEntity.setPhoto(filePath);
        sessionFactory.getCurrentSession().update(teachersEntity);
    }

    /*
     * Возвращает всех преподов админу
     */
    @SuppressWarnings("unchecked")
    public List<TeachersEntity> getAllTeachers() {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        crit.addOrder(org.hibernate.criterion.Order.asc("id"));
        return crit.list();
    }

    /*
     * Возвращает отфильтрованных по имени преподов по запросу админа
     */
    @SuppressWarnings("unchecked")
    public List<TeachersEntity> getTeacherByName(String name) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        crit.add(Restrictions.or(
                Restrictions.like("firstName", "%" + name + "%"),
                Restrictions.like("lastName", "%" + name + "%")));
        //crit.addOrder(org.hibernate.criterion.Order.asc("id"));
        return crit.list();
    }

    /*
     * Блокировка препода
     */
    public void blockTeacher(Integer teacherId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        TeachersEntity teacher = (TeachersEntity) crit.add(Restrictions.eq("id", teacherId)).uniqueResult();
        teacher.getUsersEntity().setEnable(false);
        sessionFactory.getCurrentSession().update(teacher);
    }

    /*
     * Блокировка препода
     */
    public void unblockTeacher(Integer teacherId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        TeachersEntity teacher = (TeachersEntity) crit.add(Restrictions.eq("id", teacherId)).uniqueResult();
        teacher.getUsersEntity().setEnable(true);
        sessionFactory.getCurrentSession().update(teacher);
    }

    /*
     *  Редактирование информации о преподе
     */
    public void changeTeacherInfo(Integer teacherId, String lastName, String firstName, String secondName) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        TeachersEntity teacher = (TeachersEntity) crit.add(Restrictions.eq("id", teacherId)).uniqueResult();
        teacher.setLastName(lastName);
        teacher.setFirstName(firstName);
        teacher.setSecondName(secondName);
        sessionFactory.getCurrentSession().update(teacher);
    }
}

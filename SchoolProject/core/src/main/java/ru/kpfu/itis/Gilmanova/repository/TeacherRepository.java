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
}

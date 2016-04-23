package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;

/**
 * Created by Adel on 17.04.2016.
 */
@Repository
public class TeacherRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public TeachersEntity getTeacher(Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        return (TeachersEntity) crit.add(Restrictions.eq("id", userId)).uniqueResult();
    }

    public void addPhoto(String filePath, Integer userId) {
        TeachersEntity teachersEntity = getTeacher(userId);
        teachersEntity.setPhoto(filePath);
        sessionFactory.getCurrentSession().update(teachersEntity);
    }

}

package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;

/**
 * Created by Adel on 09.04.2016.
 */
@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public StudentsEntity getStudent(Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(StudentsEntity.class);
        return (StudentsEntity) crit.add(Restrictions.eq("id",userId)).uniqueResult();
    }
}

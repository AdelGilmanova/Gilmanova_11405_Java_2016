package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;

import java.util.List;

/**
 * Created by Adel on 25.04.2016.
 */
@Repository
public class ClassesRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Возвращет все классы из бд
     */
    @SuppressWarnings("unchecked")
    public List<ClassesEntity> getAllClasses() {
        return sessionFactory.getCurrentSession().createCriteria(ClassesEntity.class).list();
    }

    /*
     * Возвращает список классов, в которых ведет препод с этим id
     */
    @SuppressWarnings("unchecked")
    public List<ClassesEntity> getClasses(Integer teacherId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassesEntity.class);
        crit.createAlias("class_teacher_object_id", "class_teacher_object");
        crit.createAlias("class_teacher_object.teacher_object_id", "teacher_object");
        crit.add(Restrictions.eq("teacher_object.teachersByTeacherId.id", teacherId));
        return crit.list();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

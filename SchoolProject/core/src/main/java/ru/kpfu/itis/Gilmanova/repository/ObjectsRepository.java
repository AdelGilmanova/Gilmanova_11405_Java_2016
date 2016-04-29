package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.ObjectsEntity;

import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Repository
public class ObjectsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Возвращает предмет по его id
     */
    public ObjectsEntity getObject(int objectId) {
        return (ObjectsEntity) sessionFactory.getCurrentSession().createCriteria(ObjectsEntity.class)
                .add(Restrictions.eq("id", objectId)).uniqueResult();
    }

    /*
     * Возвращает список предеметов, которые ведет преподаватель c данным id
     */
    @SuppressWarnings("unchecked")
    public List<ObjectsEntity> getObjects(Integer teacherId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(ObjectsEntity.class);
        crit.createAlias("teacher_object", "teacher_object")
                .add(Restrictions.eq("teacher_object.teachersByTeacherId.id", teacherId));
        crit.addOrder(org.hibernate.criterion.Order.desc("object"));
        return crit.list();
    }

    /*
     * Возвращает список всех предеметов
     */
    @SuppressWarnings("unchecked")
    public List<ObjectsEntity> getAllObjects() {
        return sessionFactory.getCurrentSession().createCriteria(ObjectsEntity.class).list();
    }
}

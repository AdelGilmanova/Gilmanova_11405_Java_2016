package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.ClassTeacherObjectEntity;
import ru.kpfu.itis.Gilmanova.model.HomeWorkEntity;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

/**
 * Created by Adel on 28.04.2016.
 */
@Repository
public class HomeWorkRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Возвращает все домашки ученика по id его класса
     */
    @SuppressWarnings("unchecked")
    public List<HomeWorkEntity> getHomeWorksByClassId(Integer classId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(HomeWorkEntity.class);
        crit.createAlias("classTeacherObjectById", "class_teacher_object");
        crit.add(Restrictions.eq("class_teacher_object.class_id.id", classId));
        crit.addOrder(org.hibernate.criterion.Order.desc("date"));
        return crit.list();
    }

    /*
     * Добавляет новую домашку в бд
     */
    public void addHomeWork(Integer classId, Integer objectId, Integer teacherId,
                            String home_work, Time time, Date date) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassTeacherObjectEntity.class);
        crit.add(Restrictions.eq("class_id.id", classId));
        crit.createAlias("teacher_object_id", "teacher_object");
        crit.add(Restrictions.eq("teacher_object.objectsEntity.id", objectId));
        crit.add(Restrictions.eq("teacher_object.teachersByTeacherId.id", teacherId));
        ClassTeacherObjectEntity classTeacherObjectEntity = (ClassTeacherObjectEntity) crit.uniqueResult();
        HomeWorkEntity homeWork = new HomeWorkEntity(home_work, classTeacherObjectEntity, time, date);
        sessionFactory.getCurrentSession().save(homeWork);
    }
}

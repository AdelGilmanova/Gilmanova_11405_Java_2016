package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.*;
import ru.kpfu.itis.Gilmanova.service.ClassesService;
import ru.kpfu.itis.Gilmanova.service.ObjectsService;

import java.util.List;

/**
 * Created by Adel on 17.04.2016.
 */
@Repository
public class TeacherRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private ObjectsService objectsService;
    @Autowired
    private ClassesService classesService;

    /*
     * Возвращает учителя по userId
     */
    public TeachersEntity getTeacherByUserId(Integer userId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeachersEntity.class);
        return (TeachersEntity) crit.add(Restrictions.eq("usersEntity.id", userId)).uniqueResult();
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

    /*
     * Проверка на существование связи препод-предмет, если не сущ-ет возврвщает true
     */
    public boolean checkTeacher_Object(Integer teacherId, Integer objectId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeacherObjectEntity.class);
        crit.add(Restrictions.eq("teachersByTeacherId.id", teacherId));
        crit.add(Restrictions.eq("objectsEntity.id", objectId));
        TeacherObjectEntity entity = (TeacherObjectEntity) crit.uniqueResult();
        return entity == null;
    }

    /*
     * Добавление новой связи препод-предмет
     */
    public void addObject(Integer teacherId, Integer objectId) {
        TeachersEntity teachersEntity = getTeacherByUserId(teacherId);
        ObjectsEntity objectsEntity = objectsService.getObject(objectId);
        TeacherObjectEntity entity = new TeacherObjectEntity(teachersEntity, objectsEntity);
        sessionFactory.getCurrentSession().save(entity);
    }

    /*
     * Проверка на существование связи класс-препод, если не сущ-ет возврвщает true
     */
    public boolean checkClass_Teacher(Integer classId, Integer teacherId, Integer objectId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(ClassTeacherObjectEntity.class);
        crit.add(Restrictions.eq("class_id.id", classId));
        crit.createAlias("teacher_object_id", "teacher_object");
        crit.add(Restrictions.eq("teacher_object.teachersByTeacherId.id", teacherId));
        crit.add(Restrictions.eq("teacher_object.objectsEntity.id", objectId));
        TeacherObjectEntity entity = (TeacherObjectEntity) crit.uniqueResult();
        return entity == null;
    }

    /*
     * Возврящает связь препод-предмет
     */
    public TeacherObjectEntity getTeacher_Object(Integer teacherId, Integer objectId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(TeacherObjectEntity.class);
        crit.add(Restrictions.eq("teachersByTeacherId.id", teacherId));
        crit.add(Restrictions.eq("objectsEntity.id", objectId));
        return (TeacherObjectEntity) crit.uniqueResult();
    }

    /*
     * Добавление новую связи класс-препод-предмет
     */
    public void addClass(Integer classId, Integer teacherId, Integer objectId) {
        ClassesEntity classesEntity = classesService.getClazz(classId);
        TeacherObjectEntity teacherObjectEntity = getTeacher_Object(teacherId, objectId);
        ClassTeacherObjectEntity classTeacherObjectEntity = new ClassTeacherObjectEntity(classesEntity, teacherObjectEntity);
        sessionFactory.getCurrentSession().save(classTeacherObjectEntity);
    }
}

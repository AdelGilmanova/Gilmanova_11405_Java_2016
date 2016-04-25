package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.SessionFactory;
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
}

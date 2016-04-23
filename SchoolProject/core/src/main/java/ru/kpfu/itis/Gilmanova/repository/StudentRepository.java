package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Adel on 09.04.2016.
 */
@Repository
public class StudentRepository {
    @Autowired
    private SessionFactory sessionFactory;

}

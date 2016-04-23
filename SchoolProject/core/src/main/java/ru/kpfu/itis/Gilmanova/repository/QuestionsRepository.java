package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.QuestionsEntity;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Adel on 07.04.2016.
 */
@Repository
public class QuestionsRepository {
    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Добавление вопроса в бд
     */
    @SuppressWarnings("unchecked")
    public void addQuestions(String theme, String text, String email, String name, Time time, Date date) {
        QuestionsEntity questionsEntity = new QuestionsEntity(theme, text, email, name, time, date);
        sessionFactory.getCurrentSession().save(questionsEntity);
    }
}

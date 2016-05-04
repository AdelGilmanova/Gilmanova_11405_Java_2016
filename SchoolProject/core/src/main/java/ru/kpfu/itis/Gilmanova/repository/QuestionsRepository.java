package ru.kpfu.itis.Gilmanova.repository;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.Gilmanova.model.QuestionsEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

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

    /*
     * Получение списка всех вопросов
     */
    @SuppressWarnings("unchecked")
    public List<QuestionsEntity> getAllQuestions() {
        return sessionFactory.getCurrentSession().createCriteria(QuestionsEntity.class).list();
    }

    /*
     * Удаление вопроса
     */
    public void deleteQuestion(int questionId) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(QuestionsEntity.class);
        QuestionsEntity entity = (QuestionsEntity) crit.add(Restrictions.eq("id", questionId)).uniqueResult();
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
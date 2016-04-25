package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.CommentsEntity;
import ru.kpfu.itis.Gilmanova.repository.CommentsRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Service
public class CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;

    @Transactional
    public List<CommentsEntity> getComments() {
        return commentsRepository.getComments();
    }

    @Transactional
    public void addComment(String name, String text) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        String t = calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                calendar.get(Calendar.MINUTE)+ ":" +calendar.get(Calendar.SECOND);
        String d = calendar.get(Calendar.YEAR) + "-" +
                calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        Time time = Time.valueOf(t);
        Date date = Date.valueOf(d);

        commentsRepository.addComment(name, text, time, date);
    }


    @Transactional
    public void deleteComment(Integer commentId) {
        commentsRepository.deleteComment(commentId);
    }
}

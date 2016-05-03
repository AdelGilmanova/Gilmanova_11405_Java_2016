package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.HomeWorkEntity;
import ru.kpfu.itis.Gilmanova.repository.HomeWorkRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Adel on 28.04.2016.
 */
@Service
public class HomeWorkService {
    @Autowired
    private HomeWorkRepository homeWorkRepository;

    @Transactional
    public List<HomeWorkEntity> getHomeWorksByClassId(Integer classId) {
        return homeWorkRepository.getHomeWorksByClassId(classId);
    }

    @Transactional
    public void addHomeWork(Integer classId, Integer objectId, Integer teacherId, String home_work) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, -1);
        String t = calendar.get(Calendar.HOUR_OF_DAY) + ":" +
                calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        String d = calendar.get(Calendar.YEAR) + "-" +
                calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
        Time time = Time.valueOf(t);
        Date date = Date.valueOf(d);
        homeWorkRepository.addHomeWork(classId, objectId, teacherId, home_work, time, date);
    }

}

package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.repository.TeacherRepository;

/**
 * Created by Adel on 17.04.2016.
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Transactional
    public TeachersEntity getTeacher(Integer userId) {
        return teacherRepository.getTeacher(userId);
    }

    @Transactional
    public void addPhoto(String filePath, Integer userId) {
        teacherRepository.addPhoto(filePath,userId);
    }

}

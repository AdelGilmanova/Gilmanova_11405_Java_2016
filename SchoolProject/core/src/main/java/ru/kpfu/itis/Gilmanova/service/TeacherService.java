package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;
import ru.kpfu.itis.Gilmanova.repository.TeacherRepository;
import ru.kpfu.itis.Gilmanova.repository.jpa.TeacherRepositoryJPA;

import java.util.List;

/**
 * Created by Adel on 17.04.2016.
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherRepositoryJPA teacherRepositoryJPA;

    @Transactional
    public TeachersEntity getTeacher(Integer userId) {
        return teacherRepositoryJPA.getTeacherById(userId);
    }

    @Transactional
    public void addPhoto(String filePath, Integer userId) {
        teacherRepository.addPhoto(filePath,userId);
    }

    @Transactional
    public List<TeachersEntity> getAllTeachers() {
        return teacherRepository.getAllTeachers();
    }

    @Transactional
    public List<TeachersEntity> getTeacherByName(String name) {
        return teacherRepository.getTeacherByName(name);
    }

    @Transactional
    public void blockTeacher(Integer teacherId) {
        teacherRepository.blockTeacher(teacherId);
    }

    @Transactional
    public void unblockTeacher(Integer teacherId) {
        teacherRepository.unblockTeacher(teacherId);
    }

    @Transactional
    public void changeTeacherInfo(Integer teacherId, String lastName, String firstName, String secondName) {
        teacherRepository.changeTeacherInfo(teacherId, lastName, firstName,secondName);
    }
}

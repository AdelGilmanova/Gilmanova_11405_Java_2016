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
    public TeachersEntity getTeacher(Integer teacherId) {
        return teacherRepositoryJPA.getTeacherById(teacherId);
    }

    @Transactional
    public TeachersEntity getTeacherByUserId(Integer userId) {
        return teacherRepository.getTeacherByUserId(userId);
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
        teacherRepository.changeTeacherInfo(teacherId, lastName, firstName, secondName);
    }

    @Transactional
    public boolean addObject(Integer teacherId, Integer objectId) {
        if (teacherRepository.checkTeacher_Object(teacherId, objectId)) {//если не существует такого отношения
            teacherRepository.addObject(teacherId, objectId);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean addClass(Integer classId, Integer teacherId, Integer objectId) {
        if (teacherRepository.checkClass_Teacher(classId, teacherId, objectId)) {//если не существует такого отношения
            teacherRepository.addClass(classId, teacherId, objectId);
            return true;
        }
        return false;
    }
}

package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.repository.StudentRepository;

import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public StudentsEntity getStudent(Integer userId) {
        return studentRepository.getStudent(userId);
    }

    @Transactional
    public List<StudentsEntity> getStudents(Integer teacherId, Integer objectId, String cl) {
        return studentRepository.getStudents(teacherId, objectId, cl);
    }

    @Transactional
    public Integer getStudentId(String lastName, String firstName) {
        return studentRepository.getStudentId(lastName, firstName);
    }

    @Transactional
    public List<StudentsEntity> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public List<StudentsEntity> getStudentByClass(Integer classId) {
        return studentRepository.getStudentByClass(classId);
    }

    @Transactional
    public List<StudentsEntity> getStudentByName(String name) {
        return studentRepository.getStudentByName(name);
    }

    @Transactional
    public void blockStudent(Integer studentId) {
        studentRepository.blockStudent(studentId);
    }

    @Transactional
    public void unblockStudent(int studentId) {
        studentRepository.unblockStudent(studentId);
    }

    @Transactional
    public void changedStudentInfo(Integer studentId, String lastName, String firstName, Integer classTd) {
        studentRepository.changedStudentInfo(studentId, lastName, firstName, classTd);
    }
}

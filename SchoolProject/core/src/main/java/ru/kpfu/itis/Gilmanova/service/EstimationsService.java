package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.EstimationsEntity;
import ru.kpfu.itis.Gilmanova.model.ObjectsEntity;
import ru.kpfu.itis.Gilmanova.model.StudentsEntity;
import ru.kpfu.itis.Gilmanova.repository.EstimationsRepository;

import java.util.*;

/**
 * Created by Adel on 09.04.2016.
 */
@Service
public class EstimationsService {
    @Autowired
    private EstimationsRepository estimationsRepository;
    @Autowired
    private ObjectsService objectsService;
    @Autowired
    private StudentService studentService;

    /*
     * Возвращает список с оценками ученику
     */
    @Transactional
    public Map<String, List<Integer>> getEstimationsForDiary(Integer userId, Integer half, Integer year) {
        Map<String, List<Integer>> map = new TreeMap<>();
        List<ObjectsEntity> objects = objectsService.getObjects();
        for (ObjectsEntity object : objects) {
            map.put(object.getObject(), new ArrayList<Integer>());
        }
        List<EstimationsEntity> values = estimationsRepository.getEstimationsForDiary(userId, half, year);
        for (EstimationsEntity entity : values) {
            String object = entity
                    .getStudentObjectTeacherByInfoId()
                    .getTeacherObjectByTeacherObjectId()
                    .getObjectsEntity()
                    .getObject();
            List<Integer> estimates = map.get(object);  //возврат значений ключа
            estimates.add(entity.getEstimate());
            map.put(object, estimates);
        }
        return map;
    }

    /*
     * Возвращает список класса с оценками в журнал преподавателя
     */
    @Transactional
    public Map<String, List<Integer>> getEstimationsForJournal(Integer teacherId, Integer objectId,
                                                               String cl, Integer half, Integer year) {
        Map<String, List<Integer>> map = new TreeMap<>();
        List<StudentsEntity> studentsList = studentService.getStudents(teacherId, objectId, cl);
        for (StudentsEntity student : studentsList) {
            map.put(student.getLastName() + " " + student.getFirstName(), new ArrayList<Integer>());
        }
        List<EstimationsEntity> values = estimationsRepository.getEstimationsForJournal(teacherId, objectId, cl, half, year);
        for (EstimationsEntity entity : values) {
            StudentsEntity student = entity.getStudentObjectTeacherByInfoId().getStudentsByStudentId();
            String name = student.getLastName() + " " + student.getFirstName();
            List<Integer> estimates = map.get(name);  //возврат значений ключа
            estimates.add(entity.getEstimate());
            map.put(name, estimates);
        }
        return map;
    }

    @Transactional
    public List<String> getClasses(Integer teacherId) {
        return estimationsRepository.getClasses(teacherId);
    }

    @Transactional
    public void addEstimate(Integer estimate, String studentName, Integer objectId, Integer teacherId, Integer half, Integer year) {
        String[] name = studentName.split(" ");
        Integer studentId = studentService.getStudentId(name[0], name[1]);
        estimationsRepository.addEstimate(estimate, studentId, objectId, teacherId, half, year);
    }
}

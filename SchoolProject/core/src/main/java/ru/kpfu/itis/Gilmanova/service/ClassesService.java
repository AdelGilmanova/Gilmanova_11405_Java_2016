package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.repository.ClassesRepository;
import ru.kpfu.itis.Gilmanova.repository.jpa.ClassesRepositoryJPA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adel on 25.04.2016.
 */
@Service
public class ClassesService {
    @Autowired
    private ClassesRepository classesRepository;
    @Autowired
    private ClassesRepositoryJPA classesRepositoryJPA;

    @Transactional
    public List<ClassesEntity> getAllClasses() {
        return classesRepository.getAllClasses();
    }

    @Transactional
    public List<ClassesEntity> getClasses(Integer teacherId) {
        List<ClassesEntity> list = classesRepository.getClasses(teacherId);
        List<ClassesEntity> classes = new ArrayList<>();
        for (ClassesEntity clazz : list) {
            if (!classes.contains(clazz)) classes.add(clazz);
        }
        return classes;
    }

    @Transactional
    public ClassesEntity getClazz(Integer classId){
        return classesRepositoryJPA.getClassById(classId);
    }

    public void setClassesRepository(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }
}

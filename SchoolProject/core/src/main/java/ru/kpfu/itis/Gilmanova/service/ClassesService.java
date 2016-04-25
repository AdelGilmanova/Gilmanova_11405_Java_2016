package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;
import ru.kpfu.itis.Gilmanova.repository.ClassesRepository;
import ru.kpfu.itis.Gilmanova.repository.jpa.ClassesRepositoryJPA;

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


    public List<ClassesEntity> getAllClasses() {
        return classesRepository.getAllClasses();
    }

}

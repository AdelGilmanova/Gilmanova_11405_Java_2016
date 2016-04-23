package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.Gilmanova.repository.StudentRepository;

/**
 * Created by Adel on 09.04.2016.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

}

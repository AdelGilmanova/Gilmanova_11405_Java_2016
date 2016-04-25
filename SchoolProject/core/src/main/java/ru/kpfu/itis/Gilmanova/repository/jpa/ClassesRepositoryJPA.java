package ru.kpfu.itis.Gilmanova.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.Gilmanova.model.ClassesEntity;

import java.util.List;

/**
 * Created by Adel on 25.04.2016.
 */
public interface ClassesRepositoryJPA extends JpaRepository<ClassesEntity, Long> {
    List<ClassesEntity> findAll();
}

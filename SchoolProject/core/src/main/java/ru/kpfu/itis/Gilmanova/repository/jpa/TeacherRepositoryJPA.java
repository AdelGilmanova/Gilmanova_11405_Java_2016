package ru.kpfu.itis.Gilmanova.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.Gilmanova.model.TeachersEntity;

/**
 * Created by Adel on 24.04.2016.
 */
public interface TeacherRepositoryJPA extends JpaRepository<TeachersEntity, Long> {
    TeachersEntity getTeacherById(Integer teacherId);
}
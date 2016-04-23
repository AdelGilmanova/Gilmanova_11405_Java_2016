package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.EstimationsEntity;
import ru.kpfu.itis.Gilmanova.repository.EstimationsRepository;

import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Service
public class EstimationsService {
    @Autowired
    private EstimationsRepository estimationsRepository;

    @Transactional
    public List<EstimationsEntity> getEstimationsForDiary(Integer userId, Integer half, Integer year) {
        return estimationsRepository.getEstimationsForDiary(userId, half, year);
    }

    @Transactional
    public List<EstimationsEntity> getEstimationsForJournal(Integer teacherId, Integer objectId,
                                                            String cl, Integer half, Integer year) {
        return estimationsRepository.getEstimationsForJournal(teacherId, objectId, cl, half, year);
    }

    @Transactional
    public List<String> getClasses(Integer teacherId) {
        return estimationsRepository.getClasses(teacherId);
    }

    @Transactional
    public void addEstimate(Integer estimate, Integer studentId, Integer objectId, Integer half, Integer year) {
        estimationsRepository.addEstimate(estimate, studentId, objectId, half, year);
    }
}

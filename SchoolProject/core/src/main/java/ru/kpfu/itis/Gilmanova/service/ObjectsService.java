package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.ObjectsEntity;
import ru.kpfu.itis.Gilmanova.repository.ObjectsRepository;

import java.util.List;

/**
 * Created by Adel on 09.04.2016.
 */
@Service
public class ObjectsService {
    @Autowired
    private ObjectsRepository objectsRepository;

    @Transactional
    public List<ObjectsEntity> getObjects(Integer teacherId) {
        return objectsRepository.getObjects(teacherId);
    }

    @Transactional
    public List<ObjectsEntity> getObjects() {
        return objectsRepository.getObjects();
    }

    @Transactional
    public ObjectsEntity getObject(int objectId) {
        return objectsRepository.getObject(objectId);
    }
}

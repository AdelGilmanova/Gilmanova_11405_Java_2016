package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.repository.UsersRepository;

/**
 * Created by Adel on 07.03.2016.
 */
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public UsersEntity getUser(String login) {
        return usersRepository.getUser(login);
    }


}

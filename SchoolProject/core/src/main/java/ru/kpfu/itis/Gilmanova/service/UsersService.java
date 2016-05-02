package ru.kpfu.itis.Gilmanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.repository.UsersRepository;

import java.sql.Date;

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

    @Transactional
    public void addUser(String lastName, String firstName, Integer classId, String login, String hash_pass) {
        usersRepository.addUser(lastName, firstName, classId, login, hash_pass);
    }

    @Transactional
    public void addUser(String lastName, String firstName, String secondName, Date date, String gender,
                        String login, String hash_pass) {
        usersRepository.addUser(lastName, firstName, secondName, date, gender, login, hash_pass);
    }

    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}

package ru.kpfu.itis.Gilmanova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;
import ru.kpfu.itis.Gilmanova.service.UsersService;

/**
 * Created by Adel on 31.03.2016.
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UsersService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UsersEntity userInfo = userService.getUser(login);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + login + " not found");
        return new MyUserDetail(userInfo);
    }

}

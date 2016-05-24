package ru.kpfu.itis.Gilmanova.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.Gilmanova.model.User;
import ru.kpfu.itis.Gilmanova.service.CommentModel;

/**
 * Created by Adel on 31.03.2016.
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    CommentModel model;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = model.getUser(username);
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + username + " not found");
        return new MyUserDetail(userInfo);
    }
}

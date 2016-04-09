package ru.kpfu.itis.Gilmanova.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.kpfu.itis.Gilmanova.model.UsersEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Adel on 31.03.2016.
 */
public class MyUserDetail implements UserDetails {

    /**
     * запись о пользователе из БД
     */
    private UsersEntity userInfo;

    public MyUserDetail(UsersEntity userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * @return коллекция прав доступа пользователя
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        return grantedAuthorities;
    }

    /**
     * hash пароля пользователя
     */
    @Override
    public String getPassword() {
        return userInfo.getHashPass();
    }

    /**
     * Логин (имя) пользователя
     */
    @Override
    public String getUsername() {
        return userInfo.getUsername();
    }

    /**
     * @return флаг, что срок действия аккаунта еще не истек, он активен
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь не заблокирован администраторами сайта
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * @return флаг, что срок действия пароля еще не истек, он активен
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * @return флаг, что пользователь включен и подтвержден
     */
    @Override
    public boolean isEnabled() {
        return userInfo.getEnable();
    }

    public UsersEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UsersEntity userInfo) {
        this.userInfo = userInfo;
    }
}

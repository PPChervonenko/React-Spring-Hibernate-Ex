package com.reactbss.ReactHibernateSpringbss.service;

import com.reactbss.ReactHibernateSpringbss.model.User;
import com.reactbss.ReactHibernateSpringbss.model.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String rusername);

    User findById(int id);

    UserDto update(UserDto ruserDto);
}

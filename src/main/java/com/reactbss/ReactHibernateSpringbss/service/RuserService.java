package com.reactbss.ReactHibernateSpringbss.service;

import com.reactbss.ReactHibernateSpringbss.model.Ruser;
import com.reactbss.ReactHibernateSpringbss.model.RuserDto;

import java.util.List;

public interface RuserService {

    Ruser save(RuserDto user);
    List<Ruser> findAll();
    void delete(int id);

    Ruser findOne(String rusername);

    Ruser findById(int id);

    RuserDto update(RuserDto ruserDto);
}

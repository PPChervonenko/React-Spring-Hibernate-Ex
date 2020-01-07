package com.reactbss.ReactHibernateSpringbss.repository;

import com.reactbss.ReactHibernateSpringbss.model.Ruser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuserRepository extends CrudRepository<Ruser, Integer> {

    Ruser findByUsername(String username);
}

package com.reactbss.ReactHibernateSpringbss.service.impl;


import com.reactbss.ReactHibernateSpringbss.model.Ruser;
import com.reactbss.ReactHibernateSpringbss.model.RuserDto;
import com.reactbss.ReactHibernateSpringbss.repository.RuserRepository;
import com.reactbss.ReactHibernateSpringbss.service.RuserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Transactional
@Service(value = "userService")
public class RuserServiceImpl implements RuserService {
	
	@Autowired
	private RuserRepository ruserRepository;

	public List<Ruser> findAll() {
		List<Ruser> list = new ArrayList<>();
		ruserRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		ruserRepository.deleteById(id);
	}

	@Override
	public Ruser findOne(String username) {
		return ruserRepository.findByUsername(username);
	}

	@Override
	public Ruser findById(int id) {
		Optional<Ruser> optionalUser = ruserRepository.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

    @Override
    public RuserDto update(RuserDto ruserDto) {
        Ruser ruser = findById(ruserDto.getId());
        if(ruser != null) {
            BeanUtils.copyProperties(ruserDto, ruser, "password", "username");
			ruserRepository.save(ruser);
        }
        return ruserDto;
    }

    @Override
    public Ruser save(RuserDto ruser) {
	    Ruser newRuser = new Ruser();
		newRuser .setUsername(ruser.getUsername());
		newRuser .setFirstName(ruser.getFirstName());
		newRuser .setLastName(ruser.getLastName());
		newRuser .setPassword(ruser.getPassword());
		newRuser .setAge(ruser.getAge());
		newRuser .setSalary(ruser.getSalary());
        return ruserRepository.save(newRuser);
    }
}

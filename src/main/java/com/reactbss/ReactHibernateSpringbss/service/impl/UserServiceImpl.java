package com.reactbss.ReactHibernateSpringbss.service.impl;


import com.reactbss.ReactHibernateSpringbss.model.User;
import com.reactbss.ReactHibernateSpringbss.model.UserDto;
import com.reactbss.ReactHibernateSpringbss.repository.UserRepository;
import com.reactbss.ReactHibernateSpringbss.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findById(int id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}

    @Override
    public UserDto update(UserDto userDto) {
        User user = findById(userDto.getId());
        if(user != null) {
            BeanUtils.copyProperties(userDto, user, "password", "username");
			userRepository.save(user);
        }
        return userDto;
    }

    @Override
    public User save(UserDto user) {
	    User newUser = new User();
		newUser .setUsername(user.getUsername());
		newUser .setFirstName(user.getFirstName());
		newUser .setLastName(user.getLastName());
		newUser .setPassword(user.getPassword());
		newUser .setAge(user.getAge());
		newUser .setSalary(user.getSalary());
        return userRepository.save(newUser);
    }
}

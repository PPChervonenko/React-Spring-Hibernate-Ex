package com.reactbss.ReactHibernateSpringbss.controller;

import com.reactbss.ReactHibernateSpringbss.model.ApiResponse;
import com.reactbss.ReactHibernateSpringbss.model.RuserDto;
import com.reactbss.ReactHibernateSpringbss.model.User;
import com.reactbss.ReactHibernateSpringbss.service.RuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class RuserController {

    @Autowired
    private RuserService ruserService;

    @PostMapping
    public ApiResponse<User> saveUser(@RequestBody RuserDto ruser){
        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",ruserService.save(ruser));
    }

    @GetMapping
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",ruserService.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",ruserService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<RuserDto> update(@RequestBody RuserDto ruserDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",ruserService.update(ruserDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        ruserService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}

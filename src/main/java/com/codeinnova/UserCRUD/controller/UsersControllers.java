package com.codeinnova.UserCRUD.controller;

import com.codeinnova.UserCRUD.entities.Users;
import com.codeinnova.UserCRUD.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersControllers {

    private UsersRepository usersRepository;

    public UsersControllers(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    //CREATE
    @PostMapping ("/api/User")
    public Users CreateUser (Users user){
        usersRepository.save(user);
        return user;
    };


    //READ
    @GetMapping("/api/Users")
    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    };

    //opc1
    /*
    @GetMapping("/api/User/{id}")
    public Users findUser(@PathVariable Integer id){
        Optional<Users> UserOpt = usersRepository.findById(id);

        if (UserOpt.isPresent())
            return UserOpt.get();
        else
            return null;
        // o lo que seria lo mismo
        // return UserOpt.orElse(null);
    };*/

    @GetMapping("/api/User/{id}")
    public ResponseEntity<Users> findUser(@PathVariable Integer id){
        Optional<Users> UserOpt = usersRepository.findById(id);

        if (UserOpt.isPresent())
            return ResponseEntity.ok(UserOpt.get());
        else
            return ResponseEntity.notFound().build();

        // o lo que seria lo mismo
        //return UserOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    };
}

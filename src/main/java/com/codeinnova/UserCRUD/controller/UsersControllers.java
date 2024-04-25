package com.codeinnova.UserCRUD.controller;

import com.codeinnova.UserCRUD.entities.Users;
import com.codeinnova.UserCRUD.repository.UsersRepository;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersControllers {

    private final Logger log = LoggerFactory.getLogger(UsersControllers.class);

    private UsersRepository usersRepository;
    public UsersControllers(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    //CREATE
    @PostMapping ("/api/User")
    public ResponseEntity<Users> CreateUser (@RequestBody Users user){
        if (user.getId()!=null){
            log.warn("Unexpected id");
            return ResponseEntity.badRequest().build();
        }

        Users response = usersRepository.save(user);
        return ResponseEntity.ok(response);
    };


    //READ
    //all
    @GetMapping("/api/Users")
    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    };

    //read by id
    @GetMapping("/api/User/{id}")
    public ResponseEntity<Users> findUser(@PathVariable Integer id){
        Optional<Users> UserOpt = usersRepository.findById(id);

        if (UserOpt.isPresent())
            return ResponseEntity.ok(UserOpt.get());
        else
            log.warn ("buscando un usuario inexistente");
            return ResponseEntity.notFound().build();

        // o lo que seria lo mismo
        //return UserOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    };

    //Update
    @PutMapping (("/api/User"))
    public ResponseEntity<Users> UpdateUser(@RequestBody Users user) {
        if (user.getId() == null) {
            log.warn("Expected Id");
            return ResponseEntity.badRequest().build();
        };

        if (!usersRepository.existsById(user.getId())) {
            log.warn("Trying to update a non exiist user");
            return ResponseEntity.notFound().build();
        };   ;

        Users result = usersRepository.save(user);
        return ResponseEntity.ok(result);
    };

    @DeleteMapping("/api/User/{id}")
    public ResponseEntity<Users> deleteUser (@PathVariable Integer id){
        if (!usersRepository.existsById(id)){
            log.warn(("Not found user to delete"));
            return ResponseEntity.notFound().build();
        };
        usersRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    };
}

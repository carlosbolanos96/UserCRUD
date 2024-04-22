package com.codeinnova.UserCRUD.controller;
import com.codeinnova.UserCRUD.entities.Users;
import com.codeinnova.UserCRUD.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UsersControllersTest {

    private UsersControllers usersControllers;
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository = Mockito.mock(UsersRepository.class);
        usersControllers = new UsersControllers(usersRepository);

        Mockito.when(usersRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Users(1, "Juan", "Perez", "prueba@mymail.com", "123456", 20, 3216547412L),
                        new Users(2, "Maria", "Lopez", "prueba1@mymail.com", "123456", 24, 3203253652L)
                ));
    }

    @Test
    void createUser() {
        Users user = new Users();
        when(usersRepository.save(user)).thenReturn(user);

        assertEquals(user, usersControllers.CreateUser(user));
    }

    @Test
    void findAllUsers() {
        usersControllers.findAllUsers();
        List<Users> users1 = usersRepository.findAll();
        assertEquals(Arrays.asList(1,2), users1.stream().map(Users::getId).collect(Collectors.toList()));

    }

}
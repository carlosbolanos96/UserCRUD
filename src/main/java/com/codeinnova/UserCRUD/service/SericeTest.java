package com.codeinnova.UserCRUD.service;

import com.codeinnova.UserCRUD.entities.Users;

public class SericeTest {

    public boolean filterContent (Users users){

        boolean ContentForMaturePublic;
        Integer age = users.getAge();

        if (age>18){
            ContentForMaturePublic = true;
        }
        else {
            ContentForMaturePublic = false;
        }
        return ContentForMaturePublic;
    };
}

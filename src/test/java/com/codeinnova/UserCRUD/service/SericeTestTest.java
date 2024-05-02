package com.codeinnova.UserCRUD.service;

import com.codeinnova.UserCRUD.entities.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SericeTestTest {

    @Test
    void filterContent() {
        Integer Age = 12;
        Users testUser = new Users(null,"test","juanito", "example@gmail.com","pw1234",Age,3216549870L);
        SericeTest filter = new SericeTest();
        boolean MatureContent = filter.filterContent(testUser);
        if (Age > 18){
            assertTrue(MatureContent);
        }else {
            assertFalse(MatureContent);
        }
    }
}
package com.codeinnova.UserCRUD.repository;

import com.codeinnova.UserCRUD.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <Users,Integer>{


}

package com.codeinnova.UserCRUD;

import com.codeinnova.UserCRUD.entities.Users;
import com.codeinnova.UserCRUD.repository.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UserCrudApplication {

	public static void main(String[] args) {
		//SpringApplication.run(UserCrudApplication.class, args);
		ApplicationContext context = SpringApplication.run(UserCrudApplication.class, args);
		UsersRepository repository = context.getBean(UsersRepository.class);

		System.out.println("Cantidad de usuarios: " + repository.count());

		//Create
		Users user = new Users(null,"Fernandez","Carlos","cralos@bol.com","123456AA",27,3149547L);
		repository.save(user);
		System.out.println("Cantidad de usuarios: " + repository.count());

		Users user1 = new Users(null,"Benachi","Marcela","MArcela@bol.com","12345BBB",24,3249547L);
		repository.save(user1);
		System.out.println("Cantidad de usuarios: " + repository.count());

		//Read
		System.out.println("Usuarios:" + repository.findAll());

		//Update


		//Delete
		//repository.deleteById(1);
		System.out.println("Cantidad de usuarios: " + repository.count());
		System.out.println("Usuarios:" + repository.findAll());
	}

}

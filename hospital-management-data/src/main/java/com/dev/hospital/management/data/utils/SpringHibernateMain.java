package com.dev.hospital.management.data.utils;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dev.hospital.management.data.bean.User;
import com.dev.hospital.management.data.service.UserService;
import com.dev.hospital.management.data.spring.config.PersistenceJPAConfig;

public class SpringHibernateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);

			UserService userService = context.getBean(UserService.class);

			// Add Users
//			userService.add(new User("Sunil", "Bora"));
//			userService.add(new User("David", "Miller"));
//			userService.add(new User("Sameer", "Singh"));
//			userService.add(new User("Paul", "Smith"));

			// Get Users
			List<User> users = userService.listUsers();
			for (User user : users) {
				System.out.println("Id = " + user.getId());
				System.out.println("First Name = " + user.getUsername());
				System.out.println("Last Name = " + user.getPassword());
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

}

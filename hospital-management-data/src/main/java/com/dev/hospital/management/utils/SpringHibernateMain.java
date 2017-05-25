package com.dev.hospital.management.utils;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dev.hospital.management.bean.Doctor;
import com.dev.hospital.management.bean.Person;
import com.dev.hospital.management.dao.PersonDao;

public class SpringHibernateMain {
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDao personDao = context.getBean(PersonDao.class);
		
		Person person = new Doctor("firstname", "lastname", new Date());
		
		personDao.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDao.getDoctors();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}
		//close resources
		context.close();	
	}

}

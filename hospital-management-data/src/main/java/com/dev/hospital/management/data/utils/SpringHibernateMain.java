package com.dev.hospital.management.data.utils;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dev.hospital.management.data.bean.Doctor;
import com.dev.hospital.management.data.service.PersonService;
import com.dev.hospital.management.data.spring.config.PersistenceJPAConfig;

public class SpringHibernateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = null;
		try {
			context = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);

			PersonService personService = context.getBean(PersonService.class);
			
			// Get Doctors
			List<Doctor> doctors = personService.getDoctors();
			for (Doctor doctor : doctors) {
				System.out.println(doctor);
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

package com.bhavna.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bahvna.jdbc.entity.Student;
import com.bhavna.jdbc.dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Program started");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/bhavna/jdbc/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		Student student = new Student();
		student.setId(103);
		student.setName("jaspreet kaur");
		student.setCity("Amristar");

		// TO insert
		// studentDao.insert(student);

		// To Update
		// studentDao.update(student);

		// To Delete
		// studentDao.delete(104);

		// To Select
		Student student1 = studentDao.getStudent(102);
		System.out.println(student1);
		
		

	}
}

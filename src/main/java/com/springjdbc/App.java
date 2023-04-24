package com.springjdbc;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.springjdbc.dao.StudentDao;
import com.springjdbc.entities.Student;

public class App 
{
    private static List<Student> allStudent;

	public static void main( String[] args )
    {
        System.out.println( "program start..." );
        ApplicationContext con=new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao studentDao= con.getBean("studentDao",StudentDao.class);
//        Student student=new Student();
        //insert
//        student.setId(103);
//        student.setName("avijeet patil");
//        student.setCity("pune");
//        int res = studentDao.insert(student);
//        System.out.println("record in database "+res );
        
        //update
//        student.setId(102);
//        student.setName("mohit verma");
//        student.setCity("Mumbai");
//        int res=studentDao.change(student);
//        System.out.println("record in database is updates "+res);
        
        //delete
//        student.setId(103);
//        int res=studentDao.deleteData(student);
//        System.out.println("record delete successfully "+res);
        
        //select
//        Student student1 = studentDao.getStudent(101);
//        System.out.println("select row "+student1);
//        
        //selecting all student
        List<Student> student= studentDao.getAllStudent();
        for (Student student2 : student) {
			System.out.println(student2);
		}
        
        
       
    

    }
}
 
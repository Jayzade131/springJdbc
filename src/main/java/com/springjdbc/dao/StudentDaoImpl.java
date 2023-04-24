package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		
		 //insert query
        String query="insert into student(id,name,city) values(?,?,?)";
        int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return r;
	}

	public int change(Student student) {
		//update query
		String query="update student set name=? , city=? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
				
		return r;
	}

	public int deleteData(Student student) {
		//delete query
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query,student.getId());
		return r;
	}

	public Student getStudent(int id) {
	//selecting(show one student data )
		
		String query="select * from student where id=?";
		RowMapper<Student>rowMapper= new RowMapperImp();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper,id);
		return student;
	}

	public List<Student> getAllStudent() {
		//selecting all student data
		String query="select * from student";
		 List<Student> student = this.jdbcTemplate.query(query,new RowMapperImp());
		
		return student;
	}
	
}

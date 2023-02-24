package com.bhavna.jdbc.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bahvna.jdbc.entity.Student;

public class StudentDaoImpl implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		try {
			String query = "insert into student(id,name,city) values(?,?,?)";
			int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
			return result;
		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public int update(Student student) {
		try {
			String query = "update student set name=? , city=? where id=?";
			int result = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
			return result;
		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public int delete(int studentId) {
		try {
			String query = "delete from student where id=?";
			int result = this.jdbcTemplate.update(query, studentId);
			return result;
		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public Student getStudent(int studentId) {
		try {
			String query = "select * from student where id=?";
			RowMapper<Student> rowMapper = new RowMapperImpl();
			Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
			return student;
		} catch (InvalidResultSetAccessException e) {
			throw new RuntimeException(e);
		} catch (DataAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}

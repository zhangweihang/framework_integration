package com.ihtc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ihtc.bean.Student;
import com.ihtc.dao.StudentDao;

@Transactional
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public boolean myInsert(Student student) {
		return studentDao.myInsert(student);
	}

	@Override
	public List<Student> selectAll() {
		return studentDao.selectAll();
	}

	@Override
	public void update(Student student) {
		studentDao.update(student);
	}

	@Override
	public Student findById(Integer sid) {
		return studentDao.findById(sid);
	}

	@Override
	public void myDelete(Student student) {
		studentDao.myDelete(student);
	}

}

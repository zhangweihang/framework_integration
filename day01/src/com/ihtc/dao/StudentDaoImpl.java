package com.ihtc.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ihtc.bean.Student;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	@Override
	public boolean myInsert(Student student) {
		Serializable sid = this.getHibernateTemplate().save(student);
		return (Integer)sid > 0;
	}

	@Override
	public List<Student> selectAll() {
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) this.getHibernateTemplate().find("from Student");
		return list;
	}

	@Override
	public void update(Student student) {
		this.getHibernateTemplate().update(student);
	}

	@Override
	public Student findById(Integer sid) {
		Student student = (Student) this.getHibernateTemplate().find("from Student where sid=?", sid).get(0);
		return student;
	}

	@Override
	public void myDelete(Student student) {
		this.getHibernateTemplate().delete(student);
	}

}

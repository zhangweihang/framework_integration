package com.ihtc.action;

import java.util.List;

import com.ihtc.bean.Student;
import com.ihtc.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class StudentAction extends ActionSupport implements ModelDriven<Student>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Student student = new Student();
	
	@Override
	public Student getModel() {
		return student;
	}
	
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	
	public String student(){
		
		if(student != null){
			studentService.myInsert(student);
			return "select";
		}
		
		return "student";
		
	}
	
	public String selectAll(){
		
		List<Student> list = studentService.selectAll();
		
		if(list != null && list.size()>0){
			ValueStack stack = ActionContext.getContext().getValueStack();
			stack.set("list", list);
			
			return "selectAll";
		}
		
		
		return "student";
		
	}
	
	public String update(){
		studentService.update(student);
		return "select";
	}
	
	public String delete(){
		Student s = studentService.findById(student.getSid());
		studentService.myDelete(s);
		return "select";
	}

}


















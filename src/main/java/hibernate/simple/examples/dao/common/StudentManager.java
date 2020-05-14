package hibernate.simple.examples.dao.common;

import java.util.List;

import hibernate.simple.examples.entity.Student;

public interface StudentManager {
	
	public void saveStudent(Student student);
	public List<Student> getStudents();
	public Student getStudent(Integer id);
	public void updateStudent(Student student);

}

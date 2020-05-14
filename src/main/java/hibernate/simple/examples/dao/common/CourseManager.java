package hibernate.simple.examples.dao.common;

import java.util.List;

import hibernate.simple.examples.entity.Course;

public interface CourseManager {
	
	public void saveCourse(Course course);
	public Course getCourse(Integer id);
	public List<Course> getCourses();
	public void updateCourse(Course course);

}

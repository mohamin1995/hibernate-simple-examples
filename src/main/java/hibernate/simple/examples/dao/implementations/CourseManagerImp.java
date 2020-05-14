package hibernate.simple.examples.dao.implementations;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.simple.examples.config.HibernateUtil;
import hibernate.simple.examples.dao.common.CourseManager;
import hibernate.simple.examples.entity.Course;

public class CourseManagerImp implements CourseManager {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	
	@Override
	public void saveCourse(Course course) {

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.save(course);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}
	}

	@Override
	public Course getCourse(Integer id) {

		Session session = sessionFactory.openSession();

		Course result;
		try {

			result = session.get(Course.class, id);

			return result;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
	}

	@Override
	public List<Course> getCourses() {

		Session session = sessionFactory.openSession();

		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Course> criteria = builder.createQuery(Course.class);
			Root<Course> root = criteria.from(Course.class);
			criteria.select(root);
			Query<Course> query = session.createQuery(criteria);
			List<Course> courses = query.getResultList();
			return courses;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}

	}

	@Override
	public void updateCourse(Course course) {

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.update(course);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}

	}

}

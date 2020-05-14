package hibernate.simple.examples.dao.implementations;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.simple.examples.config.HibernateUtil;
import hibernate.simple.examples.dao.common.StudentManager;
import hibernate.simple.examples.entity.Student;

public class StudentManagerImp implements StudentManager {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void saveStudent(Student student) {
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.save(student);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}
		
	}

	@Override
	public List<Student> getStudents() {
		
		Session session = sessionFactory.openSession();

		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
			Root<Student> root = criteria.from(Student.class);
			criteria.select(root);
			Query<Student> query = session.createQuery(criteria);
			List<Student> students = query.getResultList();
			return students;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
		
	}

	@Override
	public Student getStudent(Integer id) {
	
		Session session = sessionFactory.openSession();

		Student result;
		try {

			result = session.get(Student.class, id);

			return result;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
	}

	@Override
	public void updateStudent(Student student) {
		
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.update(student);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}

		
		
	}

}

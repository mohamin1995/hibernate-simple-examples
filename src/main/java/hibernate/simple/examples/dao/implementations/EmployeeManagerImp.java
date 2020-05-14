package hibernate.simple.examples.dao.implementations;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.simple.examples.config.HibernateUtil;
import hibernate.simple.examples.dao.common.EmployeeManager;
import hibernate.simple.examples.entity.Employee;

public class EmployeeManagerImp implements EmployeeManager {

	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void saveEmployee(Employee employee) {

		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.save(employee);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}
	}

	@Override
	public Employee getEmployee(Integer id) {
		
		Session session = sessionFactory.openSession();

		Employee result;
		try {

			result = session.get(Employee.class, id);

			return result;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
	}

	@Override
	public List<Employee> getEmployees() {

		Session session = sessionFactory.openSession();

		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> root = criteria.from(Employee.class);
			criteria.select(root);
			Query<Employee> query = session.createQuery(criteria);
			List<Employee> employees = query.getResultList();
			return employees;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.update(employee);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}
		
	}

}

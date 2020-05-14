package hibernate.simple.examples.dao.implementations;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.simple.examples.config.HibernateUtil;
import hibernate.simple.examples.dao.common.RoleManager;
import hibernate.simple.examples.entity.Role;

public class RoleManagerImp implements RoleManager {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void saveRole(Role role) {
		Session session = sessionFactory.openSession();


		try {
			session.beginTransaction();

			session.save(role);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}
		
	}

	@Override
	public Role getRole(Integer id) {
		
		Session session = sessionFactory.openSession();

		Role result;
		try {

			result = session.get(Role.class, id);

			return result;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
	}

	@Override
	public List<Role> getRoles() {
		
		Session session = sessionFactory.openSession();

		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
			Root<Role> root = criteria.from(Role.class);
			criteria.select(root);
			Query<Role> query = session.createQuery(criteria);
			List<Role> roles = query.getResultList();
			return roles;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
	}

}

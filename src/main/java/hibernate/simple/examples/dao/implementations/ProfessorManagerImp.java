package hibernate.simple.examples.dao.implementations;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.simple.examples.config.HibernateUtil;
import hibernate.simple.examples.dao.common.ProfessorManager;
import hibernate.simple.examples.entity.Professor;

public class ProfessorManagerImp implements ProfessorManager {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void saveProfessor(Professor professor) {
		
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.save(professor);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}
		
		
	}

	@Override
	public List<Professor> getProfessors() {
	
		Session session = sessionFactory.openSession();

		try {

			CriteriaBuilder builder = session.getCriteriaBuilder();

			CriteriaQuery<Professor> criteria = builder.createQuery(Professor.class);
			Root<Professor> root = criteria.from(Professor.class);
			criteria.select(root);
			Query<Professor> query = session.createQuery(criteria);
			List<Professor> professors = query.getResultList();
			return professors;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
		
	}

	@Override
	public Professor getProfessor(Integer id) {
	
		Session session = sessionFactory.openSession();

		Professor result;
		try {

			result = session.get(Professor.class, id);

			return result;

		} catch (Exception ex) {

			ex.printStackTrace();
			return null;
		}finally {
			
			session.close();
		}
		
	}

	@Override
	public void updateProfessor(Professor professor) {
		
		Session session = sessionFactory.openSession();

		try {
			session.beginTransaction();

			session.update(professor);

			session.getTransaction().commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		}finally {
			
			session.close();
		}

		
		
	}

	
	
	
}

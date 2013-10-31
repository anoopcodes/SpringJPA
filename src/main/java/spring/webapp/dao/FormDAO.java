package spring.webapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.webapp.model.UserModel;

@Repository
@Transactional
public class FormDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void saveForm(UserModel userModel) {

		// UserModel um = new UserModel();
		/*
		 * @SuppressWarnings("deprecation") SessionFactory sessionFactory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * sessionFactory.openSession(); session.beginTransaction();
		 * session.save(userModel); session.getTransaction().commit();
		 * session.close();
		 */
		entityManager.persist(userModel);

		System.out.println("successful " + userModel.getPassword());

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}

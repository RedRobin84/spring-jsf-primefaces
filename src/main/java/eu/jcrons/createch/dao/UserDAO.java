package eu.jcrons.createch.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import eu.jcrons.createch.model.User;

/**
 * User DAO
 * 
 * @author Tomas Jakubco
 * 
 */
public class UserDAO implements IUserDAO {

	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory
	 *            - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add User
	 * 
	 * @param User
	 *            - User
	 */
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            - User
	 */
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	/**
	 * Delete User
	 * 
	 * @param User
	 *            - User
	 */
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	/**
	 * Get User By ID
	 * 
	 * @param int - User ID return User - User
	 */
	public User getUserByID(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from users where id = ?").setParameter(0, id)
				.list();
		return (User) list.get(0);
	}

	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<User> getUsers() {
		List<User> list = getSessionFactory().getCurrentSession()
				.createQuery("from users").list();
		return list;
	}

}

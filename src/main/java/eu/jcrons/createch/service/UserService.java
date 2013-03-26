package eu.jcrons.createch.service;

import java.util.List;

import eu.jcrons.createch.dao.IUserDAO;
import eu.jcrons.createch.model.User;

/**
 * User Service
 * 
 * @author Tomas Jakubco
 *
 */
public class UserService implements IUserService {

	// UserDAO is injected
	IUserDAO userDAO;
	
	/**
	 * Get User DAO
	 * 
	 * @return IUserDAO - User DAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}
	
	/**
	 * Set User Dao
	 * 
	 * @param IUserDAO - User DAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Add New User
	 * 
	 * @param User - User
	 */
	public void addUser(User user) {
		getUserDAO().addUser(user);
	}

	/**
	 * Update User
	 * 
	 * @param User - User
	 */
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	/**
	 * Delete User
	 * 
	 * @param User - User
	 */
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}

	/**
	 * Get User By ID
	 * 
	 * @param int - User ID
	 * @return User - User
	 */
	public User getUserByID(int id) {
		return getUserDAO().getUserByID(id);
	}

	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<User> getUsers() {
		return getUserDAO().getUsers();
	}
	
}

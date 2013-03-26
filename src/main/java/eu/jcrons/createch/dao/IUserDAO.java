package eu.jcrons.createch.dao;

import java.util.List;

import eu.jcrons.createch.model.User;

/**
 * User DAO Interface
 * 
 * @author Tomas Jakubco
 *
 */
public interface IUserDAO {
	
	/**
	 * Add New User
	 * 
	 * @param User - User
	 */
	public void addUser(User user);
	
	/**
	 * Update User
	 * 
	 * @param User - User
	 */
	public void updateUser(User user);
	
	/**
	 * Delete User
	 * 
	 * @param User - User
	 */
	public void deleteUser(User user);
	
	/**
	 * Get User By ID
	 * 
	 * @param int - User ID
	 * @return User - User
	 */
	public User getUserByID(int id);
	
	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<User> getUsers();
	
}

package eu.jcrons.createch.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;
import org.springframework.dao.DataAccessException;

import eu.jcrons.createch.model.User;
import eu.jcrons.createch.service.IUserService;

/**
 * User Managed Bean
 * 
 * @author Tomas Jakubco
 * 
 */
@ManagedBean(name = "userMB")
@SessionScoped
public class UserMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	// Spring User Service is injected
	@ManagedProperty(value = "#{UserService}")
	IUserService userService;

	List<User> userList;
	
	private List<User> filteredUsers;
	
	private int id;
	private String firstName;
	private String lastName;
	private User selectedUser = new User();
	private User user = new User();
	
	/**
	 * Get User Service
	 * 
	 * @return IUserService - User Service
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Set User Service
	 * 
	 * @param IUserService
	 *            - User Service
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * Get User List
	 * 
	 * @return List - User List
	 */
	public List<User> getUserList() {
		userList = new ArrayList<User>();
		userList.addAll(getUserService().getUsers());
		return userList;
	}

	/**
	 * Set User List
	 * 
	 * @param List
	 *            - User List
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<User> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<User> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}

	/**
	 * Get User ID
	 * 
	 * @return int - User ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set User ID
	 * 
	 * @param int - User ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get First Name
	 * 
	 * @return String - First Name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set First Name
	 * 
	 * @param String
	 *            - First Name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get Last Name
	 * 
	 * @return String - Last Name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set Last Name
	 * 
	 * @param String
	 *            - Last Name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get Selected User
	 * 
	 * @return User - Selected User
	 */
	public User getSelectedUser() {
		return selectedUser;
	}

	/**
	 * Set Selected User
	 * 
	 * @param User - Selected User
	 */
	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
	 * Add New User
	 * 
	 * @return String - Response Message
	 */
	public String addUser() {
		try {
			User usr = user;
			getUserService().addUser(usr);
			user = new User();
			return SUCCESS;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	public String updateUser() {
        try {
            getUserService().updateUser(selectedUser);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR;
    }
	
	public String deleteUser() {
        try {
            getUserService().deleteUser(selectedUser);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

	/**
	 * Reset Fields
	 */
	public void reset() {
		this.setId(0);
		this.setFirstName("");
		this.setLastName("");
	}
	
	public void onRowSelect(SelectEvent event) {
	    System.out.println(selectedUser.getFirstName());
	}

}

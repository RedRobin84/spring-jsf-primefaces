package eu.jcrons.createch.managed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

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
@RequestScoped
public class UserMB {
    
    private static final long serialVersionUID = 1L;
    
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    
    // Spring User Service is injected
    @ManagedProperty(value = "#{UserService}")
    IUserService userService;
    
    private List<User> userList;
    
    private int id;
    private String firstName;
    private String lastName;
    
    /**
     * Add New User
     * 
     * @return String - Response Message
     */
    public String addUser() {
        try {
            User user = new User();
            user.setId(getId());
            user.setFirstName(getFirstName());
            user.setLastName(getLastName());
            getUserService().addUser(user);
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
     * @param IUserService - User Service
     */
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    
    /**
     * Set User List
     * 
     * @param List - User List
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
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
     * @param String - First Name
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
     * @param String - Last Name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

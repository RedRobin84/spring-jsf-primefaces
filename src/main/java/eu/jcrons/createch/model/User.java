package eu.jcrons.createch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    private int id;
    private String firstName;
    private String lastName;

    /**
     * Get User ID
     * 
     * @return int - User ID
     */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
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
    @Column(name = "first_name", nullable = false)
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
    @Column(name = "last_name", nullable = false)
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

}

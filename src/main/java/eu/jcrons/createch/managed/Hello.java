package eu.jcrons.createch.managed;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import eu.jcrons.createch.model.User;

@ManagedBean
@SessionScoped
public class Hello {

	List<User> userList;

	private String world = "Hello World!";

	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}

}

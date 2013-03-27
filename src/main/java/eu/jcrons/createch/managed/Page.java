package eu.jcrons.createch.managed;

import javax.faces.bean.ManagedBean;

@ManagedBean(eager = true)
public class Page {

	private String title = "Spring + JSF + PrimeFaces Example Application";

	public String getTitle() {
		return title;
	}

}

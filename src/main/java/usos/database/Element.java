package usos.database;

import java.util.Date;

public class Element {
	private Long id;

	private String data;
	private String login;
	private Date date;

	public Element() {
		// this form used by Hibernate
	}

	public Element(String login, String data, Date date) {
		// for application use, to create new events
		this.data = data;
		this.date = date;
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}

package com.borja.crm.dto.login;

import java.util.HashSet;
import java.util.Set;

public class Rol {

	private int id;
	private String name;
	private Set<User> users = new HashSet<User>(0);

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> categories) {
		this.users = categories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
}

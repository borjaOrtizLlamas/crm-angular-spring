package com.borja.crm.dto.login;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
	
	private String user;
	private String pass;
	private String location;
	private String dni;
	private String habilitado;
	private Set<Rol> roles = new HashSet<Rol>(0);
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	public Set<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Set<Rol> categories) {
		this.roles = categories;
	}

	
	
}

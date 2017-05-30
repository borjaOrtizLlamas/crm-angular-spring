package com.borja.crm.dto;

import java.io.Serializable;
import java.util.List;

public class RequestDTO implements Serializable{
	
	private Object objet; 
	private List<?> objects;
	private Boolean error;
	private String nameError;
	
	public Object getObjet() {
		return objet;
	}
	public void setObjet(Object objet) {
		this.objet = objet;
	}
	public List<?> getObjects() {
		return objects;
	}
	public void setObjects(List<?> objects) {
		this.objects = objects;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public String getNameError() {
		return nameError;
	}
	public void setNameError(String nameError) {
		this.nameError = nameError;
	} 
	
}

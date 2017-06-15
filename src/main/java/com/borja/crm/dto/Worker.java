package com.borja.crm.dto;

import java.io.Serializable;
import java.util.Date;

public class Worker implements Serializable {
	
	private String nif;
	private String name;
	private String surname;
	private String address;

	private Integer age;
	private String sex;
	private boolean married;
	private int married1; 
	private Integer numberSon;
	private Integer salary;
	private Date fristDay;
	private Date lastDay;
	
	
	
	
	public int getMarried1() {
		return married1;
	}
	public void setMarried1(int married1) {
		this.married1 = married1;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public Integer getNumberSon() {
		return numberSon;
	}
	public void setNumberSon(Integer numberSon) {
		this.numberSon = numberSon;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getFristDay() {
		return fristDay;
	}
	public void setFristDay(Date fristDay) {
		this.fristDay = fristDay;
	}
	public Date getLastDay() {
		return lastDay;
	}
	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

	

}

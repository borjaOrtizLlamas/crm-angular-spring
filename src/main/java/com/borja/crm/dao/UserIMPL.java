package com.borja.crm.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.borja.crm.dto.login.User;

public class UserIMPL implements UserDAO{

	private SessionFactory sessionFactory;

	@Override
	public User getUser(String id) {
		return (User) sessionFactory.getCurrentSession().getNamedQuery("getUser").setParameter(0, id).uniqueResult(); 
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}

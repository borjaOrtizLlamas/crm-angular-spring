package com.borja.crm.dao;

import org.springframework.transaction.annotation.Transactional;

import com.borja.crm.dto.login.User;

public interface UserDAO {

	@Transactional(readOnly = true)
	public User getUser(String id);

	@Transactional(readOnly = false)
	public void addUser(User user);

	@Transactional(readOnly = false)
	public void updateUser(User user);

}

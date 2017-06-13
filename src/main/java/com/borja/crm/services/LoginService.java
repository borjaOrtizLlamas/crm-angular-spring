package com.borja.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

public class LoginService extends AbstractUserDetailsAuthenticationProvider {

	private ServicioUsuarios servicioUsuarios;

	@Override
	protected void additionalAuthenticationChecks(UserDetails arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		// TODO Auto-generated method stub

	}

	@Override
	protected UserDetails retrieveUser(String arg0, UsernamePasswordAuthenticationToken arg1)
			throws AuthenticationException {
		UserDetails user = servicioUsuarios.loadUserByUsername(arg0);
		if (!arg1.getCredentials().toString().equals(user.getPassword())) throw new AuthenticationCredentialsNotFoundException("bad pass");
		return user;
	}

	public ServicioUsuarios getServicioUsuarios() {
		return servicioUsuarios;
	}

	public void setServicioUsuarios(ServicioUsuarios servicioUsuarios) {
		this.servicioUsuarios = servicioUsuarios;
	}

	
}

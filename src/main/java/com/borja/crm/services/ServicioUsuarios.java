package com.borja.crm.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.borja.crm.dao.UserDAO;
import com.borja.crm.dto.login.Rol;

public class ServicioUsuarios implements UserDetailsService {

	private UserDAO UserIMPL;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
			com.borja.crm.dto.login.User user = UserIMPL.getUser(arg0);
			if(user == null) throw new UsernameNotFoundException("usuario no encontrado"); 
			List<GrantedAuthority> authorities	 = buildUserAuthority(user.getRoles());
			return buildUserForAuthentication(user, authorities);

		}

	private List<GrantedAuthority> buildUserAuthority(Set<Rol> roles) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (Rol rol : roles) {
			setAuths.add(new SimpleGrantedAuthority(rol.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	private User buildUserForAuthentication(com.borja.crm.dto.login.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUser(), user.getPass() , true, true, true, true, authorities); 
	}

	public UserDAO getUserIMPL() {
		return UserIMPL;
	}

	public void setUserIMPL(UserDAO userIMPL) {
		UserIMPL = userIMPL;
	}

}

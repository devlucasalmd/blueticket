package com.br.blueticket.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.br.blueticket.domain.model.User;


public class SystemUser extends org.springframework.security.core.userdetails.User{

	private static final long serialVersionUID = 1L;
	
	private User user;

	public SystemUser(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getMail(), user.getPassword(), authorities);
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}
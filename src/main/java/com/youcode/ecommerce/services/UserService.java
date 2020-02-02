package com.youcode.ecommerce.services;

import java.security.Principal;

import org.springframework.stereotype.Service;

import com.youcode.ecommerce.entities.User;



@Service
public interface UserService {
	
	public User getUser(Principal principal);

	User updateUser(Principal principal, User user);
}

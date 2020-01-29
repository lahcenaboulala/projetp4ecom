package com.youcode.ecommerce.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youcode.ecommerce.dao.RolesRepo;
import com.youcode.ecommerce.dao.UserRepo;

@Service(value = "userService")
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RolesRepo rolesRepo;

}

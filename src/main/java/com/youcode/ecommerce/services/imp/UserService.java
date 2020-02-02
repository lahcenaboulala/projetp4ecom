package com.youcode.ecommerce.services.imp;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

import com.youcode.ecommerce.dao.RolesRepo;
import com.youcode.ecommerce.dao.UserRepo;
import com.youcode.ecommerce.entities.User;

@Service
@EnableAutoConfiguration
public class UserService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RolesRepo rolesRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		for (int i = 0; i < getAllUsers().size(); i++) {
			if (getAllUsers().get(i).getUsername().equals(username)) {
				return new org.springframework.security.core.userdetails.User(getAllUsers().get(i).getUsername(),
						getAllUsers().get(i).getPassword(), new ArrayList<>());
			}
		}
		throw new UsernameNotFoundException("User not found : " + username);
	}

<<<<<<< HEAD
=======
	// roles part
//	private List<SimpleGrantedAuthority> getAuthority() {
//        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
//    }
>>>>>>> 67ce92c278ea5fbb63e0134a15b87401ffb8047b

}

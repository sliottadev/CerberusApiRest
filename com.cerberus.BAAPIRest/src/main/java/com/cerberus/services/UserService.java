package com.cerberus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Permission;
import com.cerberus.models.Rol;
import com.cerberus.models.User;
import com.cerberus.repositories.IUserRepo;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepo userRepo;
	
	@Override
	public Iterable<Rol> GetRoles() {
		return userRepo.GetRoles();
	}

	@Override
	public Iterable<User> GetUsers() {		
		return userRepo.GetUsers();
	}

	@Override
	public User GetUserById(Integer id) {
		return userRepo.GetUserById(id);
	}

	@Override
	public Iterable<Permission> GetPermissions() {
		return userRepo.GetPermissions();
	}

	@Override
	public Permission GetPermissionById(Integer id) {
		return userRepo.GetPermissionById(id);
	}

}

package com.carberus.controllers;

import com.carberus.models.Permission;
import com.carberus.models.Rol;
import com.carberus.models.User;
import com.carberus.repositories.IUserRepo;
import com.carberus.repositories.UserRepo;

public class UserController implements IUserController {

	IUserRepo userRepo = new UserRepo();
	
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

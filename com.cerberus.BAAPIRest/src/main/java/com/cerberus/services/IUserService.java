package com.cerberus.services;

import com.cerberus.models.Permission;
import com.cerberus.models.Rol;
import com.cerberus.models.User;

public interface IUserService {

	public Iterable<Rol> GetRoles();

	public Iterable<User> GetUsers();

	public User GetUserById(Integer id);

	public Iterable<Permission> GetPermissions();

	public Permission GetPermissionById(Integer id);

}

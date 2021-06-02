package com.cerberus.repositories;

import com.cerberus.models.Permission;
import com.cerberus.models.Rol;
import com.cerberus.models.User;

public interface IUserRepo {

	public Iterable<User> GetUsers();

	public User GetUserById(Integer id);

	public User CreateUser(User user);

	public User UpdateUser(User user, Integer id);

	public void DeleteUser(Integer id);

	public Iterable<Rol> GetRoles();

	public Iterable<Permission> GetPermissions();

	public Permission GetPermissionById(Integer id);

}

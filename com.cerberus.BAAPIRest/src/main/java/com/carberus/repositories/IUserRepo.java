package com.carberus.repositories;

import com.carberus.models.Permission;
import com.carberus.models.Rol;
import com.carberus.models.User;

public interface IUserRepo {

	public Iterable<Rol> GetRoles();

	public Iterable<User> GetUsers();

	public User GetUserById(Integer id);

	public Iterable<Permission> GetPermissions();

	public Permission GetPermissionById(Integer id);

}

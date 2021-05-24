package com.cerberus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerberus.models.Permission;
import com.cerberus.models.Rol;
import com.cerberus.models.User;
import com.cerberus.repositories.IUserRepo;

/**
 * Servicios de Users.
 *
 * @author Cerberus
 * @see User
 * @see IUserRepo
 */
@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepo userRepo;

	/**
	 * Retorna la lista de users.
	 *
	 * @return lista de users
	 */
	@Override
	public Iterable<User> GetUsers() {
		return userRepo.GetUsers();
	}

	/**
	 * Busca un user por Id.
	 *
	 * @param id id de user a buscar
	 * @return user existente
	 */
	@Override
	public User GetUserById(Integer id) {
		return userRepo.GetUserById(id);
	}

	/**
	 * Crea un nuevo user.
	 *
	 * @param user user a crear
	 * @return nuevo user
	 */
	public User CreateUser(User user) {
		return userRepo.CreateUser(user);
	}

	/**
	 * Actualiza user existente.
	 *
	 * @param user user a actualizar
	 * @return user actualizado
	 */
	public User UpdateUser(User user, Integer id) {
		return userRepo.UpdateUser(user, id);
	}

	/**
	 * Borra user existente.
	 *
	 * @param id id de user a eliminar
	 */
	public void DeleteUser(Integer id) {
		userRepo.DeleteUser(id);
	}

	@Override
	public Iterable<Rol> GetRoles() {
		return userRepo.GetRoles();
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

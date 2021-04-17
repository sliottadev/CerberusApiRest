package com.cerberus.repositories;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Permission;
import com.cerberus.models.Rol;
import com.cerberus.models.User;

@Repository
public class UserRepo implements IUserRepo {

	private EntityManagerFactory emf;
	private EntityManager manager;
	private Logger log;

	public UserRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
		this.log = new Logger();
	}	

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Rol> GetRoles() {
		
		this.log.Write(LoggerType.LOG_START, "GetRoles");
		Iterable<Rol> aux = new ArrayList<Rol>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Rol").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de roles");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetRoles");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<User> GetUsers() {

		this.log.Write(LoggerType.LOG_START, "GetUsers");
		Iterable<User> aux = new ArrayList<User>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM User").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Usuarios");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetUsers");
		}
		
	}

	@Override
	public User GetUserById(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetUserById = " + id.toString());
		User aux = new User();
		try {
			
			this.manager.getTransaction().begin();
			aux = (User) this.manager.createQuery("FROM User u WHERE u.userId = "+id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener usuario id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetUserById = " + id.toString());
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Permission> GetPermissions() {

		this.log.Write(LoggerType.LOG_START, "GetPermissions");
		Iterable<Permission> aux = new ArrayList<Permission>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Permission").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Permisos");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetPermissions");
		}	
	}

	@Override
	public Permission GetPermissionById(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetPermissionById = " + id.toString());
		Permission aux = new Permission();
		try {
			
			this.manager.getTransaction().begin();
			aux = (Permission) this.manager.createQuery("FROM Permission p WHERE p.permissionId = "+id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener Permisos id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetPermissionById = " + id.toString());
		}	
	}

}

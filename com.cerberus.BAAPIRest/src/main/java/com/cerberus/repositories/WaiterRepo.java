package com.cerberus.repositories;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Waiter;
@Repository
public class WaiterRepo implements IWaiterRepo{

	private EntityManagerFactory emf;
	private EntityManager manager;
	private Logger log;
	
	public WaiterRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
		this.log = new Logger();
	}
	
	
	@Override
	public Iterable<Waiter> GetWaiters() {
		this.log.Write(LoggerType.LOG_START, "GetWaiters");
		Iterable<Waiter> aux = new ArrayList<Waiter>();
		
		try {
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Waiter").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch(Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Waiters");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetWaiters");
		}
	}


	@Override
	public Waiter GetWaiterById(Integer id) {
		this.log.Write(LoggerType.LOG_START, "GetWaiterById");
		Waiter aux = new Waiter();
		
		try {
			this.manager.getTransaction().begin();
			aux = (Waiter) this.manager.createQuery("FROM Waiter w WHERE w.waiterId = "+ id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		}catch(Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obetener Waiter por id");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetWaiterById");
		}
	}


	@Override
	public Waiter CreateWaiter(Waiter waiter) {
		this.log.Write(LoggerType.LOG_START, "CreateWaiter");
		try {
			
			this.manager.getTransaction().begin();
			this.manager.persist(waiter);
			this.manager.flush();
			this.manager.getTransaction().commit();
			
			return waiter;
		}catch(Exception e) {
			this.log.Write(LoggerType.LOG_ERROR, "Error al crear Waiter");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "CreateWaiter");
		}
	}


	@Override
	public Waiter UpdateWaiter(Waiter waiter, Integer id) {
		
		Waiter waiterToUpdate = this.GetWaiterById(id);
		this.log.Write(LoggerType.LOG_START, "UpdateWaiter");
		
		try {
			
			this.manager.getTransaction().begin();
			waiterToUpdate.setCode(waiter.getCode());
			waiterToUpdate.setName(waiter.getName());
			waiterToUpdate.setDeleted(waiter.getDeleted());
			this.manager.flush();
			this.manager.getTransaction().commit();
			
			return waiterToUpdate;
			
		}catch(Exception e) {
			this.log.Write(LoggerType.LOG_ERROR, "Error al actualizar Waiter");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "UpdateWaiter");
		}
	}


	@Override
	public Waiter DeleteWaiter(Integer id) {
		this.log.Write(LoggerType.LOG_START, "DeleteWaiter");
		
		try {
			
			Waiter waiter = this.GetWaiterById(id);
			this.manager.getTransaction().begin();
			Query query = this.manager.createQuery("DELETE FROM Waiter WHERE id = "+id.toString());
			query.executeUpdate();
			this.manager.getTransaction().commit();
			return waiter;
		}catch(Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al eliminar el Waiter");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "DeleteWaiter");
		}
	}

}

package com.carberus.repositories;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carberus.models.Mesa;
import com.carberus.models.Waiter;
import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;

public class MiscRepo implements IMiscRepo {

	private EntityManagerFactory emf;
	private EntityManager manager;
	private Logger log;
	
	public MiscRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
		this.log = new Logger();		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Waiter> GetWaiters() {

		this.log.Write(LoggerType.LOG_START, "GetWaiters");
		Iterable<Waiter> aux = new ArrayList<Waiter>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Waiter").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Meseros");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetWaiters");
		}
	}

	@Override
	public Waiter GetWaiterById(Integer id) {
		
		this.log.Write(LoggerType.LOG_START, "GetWaiterById = " + id.toString());
		Waiter aux = new Waiter();
		try {
			
			this.manager.getTransaction().begin();
			aux = (Waiter) this.manager.createQuery("FROM Waiter w WHERE w.waiterId = "+id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener Mesero id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetWaiterById = " + id.toString());
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Mesa> GetTables() {

		this.log.Write(LoggerType.LOG_START, "GetTables");
		Iterable<Mesa> aux = new ArrayList<Mesa>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Mesa").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Mesas");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetTables");
		}
	}

	@Override
	public Mesa GetTableById(Integer id) {
		
		this.log.Write(LoggerType.LOG_START, "GetTableById = " + id.toString());
		Mesa aux = new Mesa();
		try {
			
			this.manager.getTransaction().begin();
			aux = (Mesa) this.manager.createQuery("FROM Mesa m WHERE m.tableId = "+id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener Mesa id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetTableById = " + id.toString());
		}	
	}

}

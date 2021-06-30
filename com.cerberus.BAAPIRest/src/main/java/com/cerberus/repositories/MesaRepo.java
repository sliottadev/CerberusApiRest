package com.cerberus.repositories;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Mesa;



@Repository
public class MesaRepo implements IMesaRepo {

	private EntityManagerFactory emf;
	private EntityManager manager;
	private Logger log;
	
	public MesaRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
		this.log = new Logger();
	}
	
	@Override
	public Iterable<Mesa> GetMesas() {
		this.log.Write(LoggerType.LOG_START, "GetMesas");
		Iterable<Mesa> aux = new ArrayList<Mesa>();
		try {
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Mesa").getResultList();
			this.manager.getTransaction().commit();
			return aux;
		} catch(Exception e) {
			e.printStackTrace();
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Mesas");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetMesas");
		}
	}

	@Override
	public Mesa GetMesaById(Integer id) {
		this.log.Write(LoggerType.LOG_START, "GetMesaById");
		Mesa aux = new Mesa();
		try {
			this.manager.getTransaction().begin();
			aux = (Mesa) this.manager.createQuery("FROM Mesa m WHERE m.tableId = "+ id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
		}catch(Exception e) {
			e.printStackTrace();
			this.log.Write(LoggerType.LOG_ERROR, "Error al obetener Mesa por id");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetMesaById");
		}
	}

	@Override
	public Mesa CreateMesa(Mesa mesa) {
		this.log.Write(LoggerType.LOG_START, "MesaRegister");
		try {
			this.manager.getTransaction().begin();
			this.manager.persist(mesa);
			this.manager.flush();
			this.manager.getTransaction().commit();
			return mesa;
		}catch(Exception e) {
			e.printStackTrace();
			this.log.Write(LoggerType.LOG_ERROR, "Error al crear Mesa");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "MesaRegister");
		}
	}

	@Override
	public Mesa UpdateMesa(Mesa mesa, Integer id) {
		Mesa mesaToUpdate = this.GetMesaById(id);
		this.log.Write(LoggerType.LOG_START, "UpdateMesa");
		try {
			this.manager.getTransaction().begin();
			mesaToUpdate.setCode(mesa.getCode());
			mesaToUpdate.setLocation(mesa.getLocation());
			mesaToUpdate.setEnabled(mesa.getEnabled());
			mesaToUpdate.setVisible(mesa.getVisible());
			mesaToUpdate.setDeleted(mesa.getDeleted());
			this.manager.flush();
			this.manager.getTransaction().commit();
			return mesaToUpdate;
		}catch(Exception e) {
			e.printStackTrace();
			this.log.Write(LoggerType.LOG_ERROR, "Error al actualizar Mesa");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "UpdateMesa");
		}
	}

	@Override
	public Mesa DeleteMesa(Integer id) {
		this.log.Write(LoggerType.LOG_START, "DeleteMesa");
		try {
			Mesa mesa = this.GetMesaById(id);
			this.manager.getTransaction().begin();
			Query query = this.manager.createQuery("DELETE FROM Mesa WHERE id = "+id.toString());
			query.executeUpdate();
			this.manager.getTransaction().commit();
			return mesa;
		}catch(Exception e) {
			e.printStackTrace();
			this.log.Write(LoggerType.LOG_ERROR, "Error al eliminar el Mesa");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "DeleteMesa");
		}
	}

}

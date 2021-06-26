package com.cerberus.repositories;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cerberus.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Client;

@Repository
public class ClientRepo implements IClientRepo{
	
	private EntityManagerFactory emf;
	private EntityManager manager;
	
	@Autowired
	private Logger log;
	
	public ClientRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Client> GetClients() {
		
		this.log.Write(LoggerType.LOG_START, "GetClients");
		Iterable<Client> aux = new ArrayList<Client>();
		try {
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Client").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		}catch(Exception e){
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener la lista de Clientes");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetClients");
		}
	}


	@Override
	public Client GetClientById(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetClientById = " + id.toString());
		Client aux = new Client();
		try {

			this.manager.getTransaction().begin();
			aux = (Client) this.manager.createQuery("FROM Client c WHERE c.clientId = " + id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;

		} catch (Exception e) {

			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener cliente id = " + id.toString());
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetClientById = " + id.toString());
		}
	}

	@Override
	public Client CreateClient(Client client) {

		this.manager.getTransaction().begin();
		this.manager.persist(client);
		this.manager.flush();
		this.manager.getTransaction().commit();

		return client;
	}

	@Override
	public Client UpdateClient(Client client, Integer id) {
		this.log.Write(LoggerType.LOG_START, "UpdateClient");
		Client clientToUpdate = new Client();
		
		try {
			
			this.manager.getTransaction().begin();
			clientToUpdate = (Client) this.manager.createQuery("FROM Client c WHERE c.clientId = "+id.toString()).getSingleResult();
			clientToUpdate.setUserName(client.getUserName());
			clientToUpdate.setMail(client.getMail());
			clientToUpdate.setPass(client.getPass());
			clientToUpdate.setIsGuest(client.getIsGuest());
			clientToUpdate.setLogInFacebook(client.getLogInFacebook());
			clientToUpdate.setLogInGoogle(client.getLogInGoogle());
			clientToUpdate.setCreateDate(client.getCreateDate());
			clientToUpdate.setModifyDate(client.getModifyDate());
			clientToUpdate.setDeleteDate(client.getDeleteDate());
			clientToUpdate.setImage(client.getImage());
			this.manager.flush();
			this.manager.getTransaction().commit();
			
			return clientToUpdate;
			
		}catch(Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al actualizar Cliente");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			
			this.log.Write(LoggerType.LOG_END, "UpdateClient");
		}
		
	}

	@Override
	public void DeleteClient(Integer id) {
		
		try {
			
			this.log.Write(LoggerType.LOG_START, "DeleteClient");
			this.manager.getTransaction().begin();
			Query query = this.manager.createQuery("DELETE FROM Client WHERE id = "+ id.toString());
			query.executeUpdate();
			this.manager.getTransaction().commit();
			
		} catch(Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al eliminar Cliente");			
		}
		finally {
			
			this.log.Write(LoggerType.LOG_END, "DeleteClient");
		}
		
	}


	@Override
	public Client ClientLogin(Client client) {
		this.log.Write(LoggerType.LOG_START, "ClientLogin");
		Client aux = new Client();
		try {
			this.manager.getTransaction().begin();
			aux = (Client) this.manager.createQuery("FROM Client c WHERE c.pass = "+ client.getPass()+" AND (c.userName = '"+ client.getUserName()+"' OR c.mail = '"+ client.getMail()+"')").getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
		}catch(Exception e) {
			this.log.Write(LoggerType.LOG_ERROR, "Error al logear Cliente");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "ClientLogin");
		}
	}

	@Override
	public Client ClientRegister(Client client) {
		this.log.Write(LoggerType.LOG_START, "ClientRegister");
		try {
			this.manager.getTransaction().begin();
			this.manager.persist(client);
			this.manager.flush();
			this.manager.getTransaction().commit();
			return client;
		}catch(Exception e) {
			this.log.Write(LoggerType.LOG_ERROR, "Error al registrar Cliente");
			this.manager.getTransaction().rollback();
			return null;
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "ClientRegister");
		}
	}

}

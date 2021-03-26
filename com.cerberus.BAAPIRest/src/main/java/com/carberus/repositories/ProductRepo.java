package com.carberus.repositories;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.carberus.models.Option;
import com.carberus.models.Product;
import com.carberus.models.PromotionItem;
import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;

public class ProductRepo implements IProductRepo {

	private EntityManagerFactory emf;
	private EntityManager manager;
	private Logger log;
	
	public ProductRepo() {
		this.emf = Persistence.createEntityManagerFactory("Persistencia");
		this.manager = emf.createEntityManager();
		this.log = new Logger();
	}	

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Product> GetProducts() {
		
		this.log.Write(LoggerType.LOG_START, "GetProducts");
		Iterable<Product> aux = new ArrayList<Product>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Product").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Productos");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetProducts");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Option> GetProductsOptions() {

		this.log.Write(LoggerType.LOG_START, "GetProductsOptions");
		Iterable<Option> aux = new ArrayList<Option>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Option").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Opciones de Producto");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetProductsOption");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Option> GetOptionsByProductId(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetOptionsByProductId = " + id.toString());
		Iterable<Option> aux = new ArrayList<Option>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM Option o WHERE o.productId = " + id.toString()).getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Opciones de Producto con id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetOptionsByProductId" + id.toString());
		}
	}

	@Override
	public Option GetOptionById(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetOptionById = " + id.toString());
		Option aux = new Option();
		try {
			
			this.manager.getTransaction().begin();
			aux = (Option) this.manager.createQuery("FROM Option o WHERE o.optionId = " + id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener Opcion con id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetOptionById" + id.toString());
		}
	}

	@Override
	public Product GetProductById(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetProductById = " + id.toString());
		Product aux = new Product();
		try {
			
			this.manager.getTransaction().begin();
			aux = (Product) this.manager.createQuery("FROM Product p WHERE p.productId = " + id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener Producto con id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetProductById" + id.toString());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<PromotionItem> GetPromotionItems() {

		this.log.Write(LoggerType.LOG_START, "GetPromotionItems");
		Iterable<PromotionItem> aux = new ArrayList<PromotionItem>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM PromotionItem").getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Items de Promocion");
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetPromotionItems");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<PromotionItem> GetPromotionItemByPromotionId(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetPromotionItemByPromotionId = " + id.toString());
		Iterable<PromotionItem> aux = new ArrayList<PromotionItem>();
		try {
			
			this.manager.getTransaction().begin();
			aux = this.manager.createQuery("FROM PromotionItem pi WHERE pi.promotionId = " + id.toString()).getResultList();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener Items de la Promocion id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetPromotionItemByPromotionId" + id.toString());
		}
	}

	@Override
	public PromotionItem GetPromotionItemById(Integer id) {

		this.log.Write(LoggerType.LOG_START, "GetPromotionItemById = " + id.toString());
		PromotionItem aux = new PromotionItem();
		try {
			
			this.manager.getTransaction().begin();
			aux = (PromotionItem) this.manager.createQuery("FROM PromotionItem p WHERE p.promotionItemsId = " + id.toString()).getSingleResult();
			this.manager.getTransaction().commit();
			return aux;
			
		} catch (Exception e) {
			
			this.log.Write(LoggerType.LOG_ERROR, "Error al obtener Item de Promocion con id = " + id.toString());
			return null;	
		}
		finally {
			this.log.Write(LoggerType.LOG_END, "GetPromotionItemById" + id.toString());
		}
	}

}

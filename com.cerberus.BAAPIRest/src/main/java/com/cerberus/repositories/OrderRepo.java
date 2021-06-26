package com.cerberus.repositories;

import com.cerberus.enums.LoggerType;
import com.cerberus.helpers.Logger;
import com.cerberus.models.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

@Repository
public class OrderRepo implements IOrderRepo{

    private EntityManagerFactory emf;
    private EntityManager manager;
    private Logger log;

    public OrderRepo() {
        this.emf = Persistence.createEntityManagerFactory("Persistencia");
        this.manager = emf.createEntityManager();
        this.log = new Logger();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Order> GetOrders() {

        this.log.Write(LoggerType.LOG_START, "GetOrders");
        Iterable<Order> aux = new ArrayList<Order>();
        try {

            this.manager.getTransaction().begin();
            aux = this.manager.createQuery("FROM Order").getResultList();
            this.manager.getTransaction().commit();
            return aux;

        } catch (Exception e) {

            this.log.Write(LoggerType.LOG_ERROR, "Error al obtener lista de Ordenes");
            this.manager.getTransaction().rollback();
            return null;
        }
        finally {
            this.log.Write(LoggerType.LOG_END, "GetOrders");
        }

    }

    @Override
    public Order GetOrderById(Integer id) {

        this.log.Write(LoggerType.LOG_START, "GetUserById = " + id.toString());
        Order aux = new Order();
        try {

            this.manager.getTransaction().begin();
            aux = (Order) this.manager.createQuery("FROM Order o WHERE o.orderId = " + id.toString()).getSingleResult();
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

    @Override
    public Order CreateOrder(Order order) {

        this.manager.getTransaction().begin();
        this.manager.persist(order);
        this.manager.flush();
        this.manager.getTransaction().commit();

        return order;
    }

    @Override
    public Order UpdateOrder(Order order, Integer id) {

        Order orderToUpdate = this.GetOrderById(id);

        this.manager.getTransaction().begin();
        orderToUpdate.setOrderId(order.getOrderId());
        orderToUpdate.setPartialPayment(order.getPartialPayment());
        orderToUpdate.setState(order.getState());
        orderToUpdate.setBonusPorc(order.getBonusPorc());
        order.setCreateDate(order.getCreateDate());
        order.setCloseDate(order.getCloseDate());
        order.setModifyDate(order.getModifyDate());
        order.setDeleteDate(order.getDeleteDate());
        order.setClientId(order.getClientId());
        order.setTableId(order.getTableId());
        order.setWaiterId(order.getWaiterId());

        this.manager.flush();
        this.manager.getTransaction().commit();

        return orderToUpdate;
    }

    @Override
    public void DeleteOrder(Integer id) {

        this.manager.getTransaction().begin();
        Query query = this.manager.createQuery("delete from Order WHERE id = " + id.toString());
        query.executeUpdate();
        this.manager.getTransaction().commit();
    }
}

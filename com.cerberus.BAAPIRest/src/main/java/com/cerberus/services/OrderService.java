package com.cerberus.services;

import com.cerberus.models.Order;
import com.cerberus.models.User;
import com.cerberus.repositories.IOrderRepo;
import com.cerberus.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios de Orders.
 *
 * @author Cerberus
 * @see Order
 * @see IOrderRepo
 */
@Service
public class OrderService implements IOrderService{
    @Autowired
    IOrderRepo orderRepo;

    /**
     * Retorna la lista de orders.
     *
     * @return lista de orders
     */
    @Override
    public Iterable<Order> GetOrders() {
        return orderRepo.GetOrders();
    }

    /**
     * Busca un order por Id.
     *
     * @param id id de order a buscar
     * @return order existente
     */
    @Override
    public Order GetOrderById(Integer id) {
        return orderRepo.GetOrderById(id);
    }

    /**
     * Crea un nuevo order.
     *
     * @param order order a crear
     * @return nuevo order
     */
    public Order CreateOrder(Order order) {
        return orderRepo.CreateOrder(order);
    }

    /**
     * Actualiza order existente.
     *
     * @param order order a actualizar
     * @return order actualizado
     */
    public Order UpdateOrder(Order order, Integer id) {
        return orderRepo.UpdateOrder(order, id);
    }

    /**
     * Borra order existente.
     *
     * @param id id de order a eliminar
     */
    public void DeleteOrder(Integer id) { orderRepo.DeleteOrder(id);
    }

}

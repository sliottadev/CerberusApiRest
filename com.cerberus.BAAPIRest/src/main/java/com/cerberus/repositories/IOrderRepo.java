package com.cerberus.repositories;

import com.cerberus.models.Order;

public interface IOrderRepo {
    public Iterable<Order> GetOrders();

    public Order GetOrderById(Integer id);

    public Order CreateOrder(Order order);

    public Order UpdateOrder(Order order, Integer id);

    public void DeleteOrder(Integer id);

}

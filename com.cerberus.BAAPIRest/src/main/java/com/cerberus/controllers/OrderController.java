package com.cerberus.controllers;

import com.cerberus.helpers.Logger;
import com.cerberus.services.IMiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrdersController Path: "../orders/"
 * Controla: ABM Order, OrderDetails (orderByClientId, Ordenes Activas, etc)
 * Entidades relacionadas: Order, OrderDetails, Table, Waiter
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IMiscService miscService;

    @Autowired
    Logger log;

    @GetMapping("GetWaiters")
    public String GetWaiters() {
        return miscService.GetWaiters().toString();
    }

    @GetMapping("GetWaiters/{id}")
    public String GetWaiters(@PathVariable Integer id) {
        return miscService.GetWaiterById(id).toString();
    }

    @GetMapping("GetTables")
    public String GetTables() {
        return miscService.GetTables().toString();
    }

    @GetMapping("GetTables/{id}")
    public String GetTableById(@PathVariable Integer id) {
        return miscService.GetTableById(id).toString();
    }
}

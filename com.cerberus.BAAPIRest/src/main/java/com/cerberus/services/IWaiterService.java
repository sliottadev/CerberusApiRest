package com.cerberus.services;

import com.cerberus.models.Waiter;

public interface IWaiterService {

	public Iterable<Waiter> GetWaiters();

	public Waiter GetWaiterById(Integer id);

	public Waiter CreateWaiter(Waiter waiter);

	public Waiter UpdateWaiter(Waiter waiter, Integer id);

	public Waiter DeleteWaiter(Integer id);

}

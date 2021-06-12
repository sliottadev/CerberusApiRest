package com.cerberus.repositories;

import com.cerberus.models.Waiter;

public interface IWaiterRepo {

	public Iterable<Waiter> GetWaiters();

	public Waiter GetWaiterById(Integer id);

	public Waiter CreateWaiter(Waiter waiter);

	public Waiter UpdateWaiter(Waiter waiter, Integer id);

	public Waiter DeleteWaiter(Integer id);

}

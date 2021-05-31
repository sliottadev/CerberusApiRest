package com.cerberus.repositories;

import com.cerberus.models.Mesa;

public interface IMesaRepo {

	public Iterable<Mesa> GetMesas();

	public Mesa GetMesaById(Integer id);

	public Mesa MesaRegister(Mesa mesa);

	public Mesa UpdateMesa(Mesa mesa, Integer id);

	public Mesa DeleteMesa(Integer id);

}

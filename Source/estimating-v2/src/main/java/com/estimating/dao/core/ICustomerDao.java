package com.estimating.dao.core;

import com.estimating.entity.Customers;

public interface ICustomerDao {
	public void create(Customers customer);

	public Customers findOneById(Long id);

	public Customers findOneByName(String name);
}

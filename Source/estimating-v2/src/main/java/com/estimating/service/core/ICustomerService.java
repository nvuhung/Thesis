package com.estimating.service.core;

import com.estimating.entity.Customers;

public interface ICustomerService {
	public void create(Customers customer);
	public Customers findOneById(Long id);
	public Customers findOneByName(String name);
}

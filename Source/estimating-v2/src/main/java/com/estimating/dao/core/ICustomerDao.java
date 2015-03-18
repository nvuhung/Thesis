package com.estimating.dao.core;

import java.util.List;

import com.estimating.entity.Customers;

public interface ICustomerDao {
	public void create(Customers customer);
	public Customers findOneById(Long id);
	public Customers findOneByName(String name);
	public List<Customers> findAll();
}

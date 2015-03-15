package com.estimating.dao.core;

import com.estimating.entity.Departments;

public interface IDepartmentDao {
	public void create(Departments departments);

	public Departments findOneById(Long id);
}

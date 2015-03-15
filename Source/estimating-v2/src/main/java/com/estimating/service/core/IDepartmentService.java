package com.estimating.service.core;

import com.estimating.entity.Departments;

public interface IDepartmentService {
	public void create(Departments departments);

	public Departments findOneById(Long id);
}

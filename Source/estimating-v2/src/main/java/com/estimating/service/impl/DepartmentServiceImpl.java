package com.estimating.service.impl;

import org.springframework.stereotype.Service;

import com.estimating.entity.Departments;
import com.estimating.service.core.AbstractBaseService;
import com.estimating.service.core.IDepartmentService;

@Service
public class DepartmentServiceImpl extends AbstractBaseService implements
		IDepartmentService {

	@Override
	public void create(Departments departments) {
		departmentDao.create(departments);
	}

	@Override
	public Departments findOneById(Long id) {
		return departmentDao.findOneById(id);
	}

}

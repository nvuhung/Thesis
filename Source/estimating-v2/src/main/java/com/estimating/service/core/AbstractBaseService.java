package com.estimating.service.core;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.estimating.dao.core.ICustomerDao;
import com.estimating.dao.core.IDepartmentDao;
import com.estimating.dao.core.IUsersDao;
import com.estimating.utils.EstimatingConstants;
import com.estimating.validation.IValidationService;

public abstract class AbstractBaseService  {
	@Autowired protected ICustomerDao customerDao;
	@Autowired protected IDepartmentDao departmentDao;
	@Autowired protected IUsersDao userDao;

	protected Map<String, IValidationService> validationService;
	
	private EstimatingConstants estimatingConstants;

	public EstimatingConstants getEstimatingConstants() {
		return estimatingConstants;
	}

	public void setEstimatingConstants(EstimatingConstants estimatingConstants) {
		this.estimatingConstants = estimatingConstants;
	}

	public void setValidationService(Map<String, IValidationService> validationService) {
		this.validationService = validationService;
	}
	
	
}

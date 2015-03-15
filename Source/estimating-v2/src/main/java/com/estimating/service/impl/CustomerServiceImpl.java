package com.estimating.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.estimating.entity.Customers;
import com.estimating.model.MessageModel;
import com.estimating.service.core.AbstractBaseService;
import com.estimating.service.core.ICustomerService;
import com.estimating.validation.IValidationService;

@Service
public class CustomerServiceImpl extends AbstractBaseService implements
		ICustomerService {

	@Override
	public void create(Customers customer) {
		IValidationService validate = validationService.get("customerValidate");
		MessageModel messageModel = new MessageModel();
		messageModel.put(getEstimatingConstants().getVALIDATION_OBJECT(),
				customer);
		List<String> validateResult = validate.validation(messageModel);
		Assert.isNull(validateResult, "Error when validate");
		customerDao.create(customer);
	}

	@Override
	public Customers findOneById(Long id) {
		return findOneById(id);
	}

	@Override
	public Customers findOneByName(String name) {
		return findOneByName(name);
	}

}

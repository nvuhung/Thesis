package com.estimating.validation;

import java.util.ArrayList;
import java.util.List;

import com.estimating.entity.Customers;
import com.estimating.model.MessageModel;

public class CustomerValidationImpl extends AbstractBaseValidation implements
		IValidationService {

	@Override
	public List<String> validation(MessageModel messageModel) {
		List<String> result = new ArrayList<String>();
		Customers customer = (Customers) messageModel
				.get(getEstimatingConstants().getVALIDATION_OBJECT());
		if (customer.getSalary().equals(0))
			result.add("Salary must be bigger than 0");
		return result;
	}

}

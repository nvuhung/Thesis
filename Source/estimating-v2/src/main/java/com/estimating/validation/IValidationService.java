package com.estimating.validation;

import java.util.List;

import com.estimating.model.MessageModel;

public interface IValidationService {
	public List<String> validation(MessageModel messageModel);
}

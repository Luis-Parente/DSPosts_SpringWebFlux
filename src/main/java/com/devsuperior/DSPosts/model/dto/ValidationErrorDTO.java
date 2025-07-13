package com.devsuperior.DSPosts.model.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.DSPosts.model.controllers.exceptions.StandardError;

public class ValidationErrorDTO extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessageDTO> errors = new ArrayList<>();

	public ValidationErrorDTO(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public List<FieldMessageDTO> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.removeIf(x -> x.getFieldName().equals(fieldName));
		errors.add(new FieldMessageDTO(fieldName, message));
	}

}

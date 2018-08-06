package com.expertaart.refactorapp.services.validators.exceptions;

import com.expertaart.refactorapp.services.validators.AttentionErrorCode;

public class AttentionRequestValidatorsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AttentionRequestValidatorsException(AttentionErrorCode error) {
		super(error.name());
	}

}

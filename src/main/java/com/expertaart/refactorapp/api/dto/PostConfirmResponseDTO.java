package com.expertaart.refactorapp.api.dto;

import com.expertaart.refactorapp.services.validators.AttentionErrorCode;

public class PostConfirmResponseDTO {

	private AttentionErrorCode errorCode;

	public PostConfirmResponseDTO() {
	}

	public PostConfirmResponseDTO(AttentionErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public AttentionErrorCode getError() {
		return errorCode;
	}


}

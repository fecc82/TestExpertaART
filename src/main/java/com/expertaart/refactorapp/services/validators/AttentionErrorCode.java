package com.expertaart.refactorapp.services.validators;

public enum AttentionErrorCode {
	NONE(0), INVALID_REQUEST(1), CANCELLED(2), NOT_FOUND(3), NOT_USER_UUID(4), DRIVER_NOT_FOUND(5);

	private Integer id;

	AttentionErrorCode(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

}

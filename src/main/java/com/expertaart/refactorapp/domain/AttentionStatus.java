package com.expertaart.refactorapp.domain;

public enum AttentionStatus {
	REQUESTED(1), CONFIRMED(2), CANCELLED(6);
	
	private Integer id;

	AttentionStatus(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}

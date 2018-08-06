package com.expertaart.refactorapp.api.dto;

public class PostConfirmRequestDTO {

    private Long serviceId;
    private Long driverId;

    public PostConfirmRequestDTO() {
    }

    
	public PostConfirmRequestDTO(Long serviceId, Long driverId) {
		super();
		this.serviceId = serviceId;
		this.driverId = driverId;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public Long getDriverId() {
		return driverId;
	}
   
}

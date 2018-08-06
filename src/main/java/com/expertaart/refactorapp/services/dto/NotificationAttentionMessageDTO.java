package com.expertaart.refactorapp.services.dto;

public class NotificationAttentionMessageDTO {

	private Long attentionId; 
	
	private String userUUID;
	
	private String message;
	
	private RingToneNotification ringTone;
	
	public NotificationAttentionMessageDTO() {
		super();
	}

	public NotificationAttentionMessageDTO(Long attentionId, String userUUID, String message,
			RingToneNotification ringTone) {
		this.attentionId = attentionId;
		this.userUUID = userUUID;
		this.message = message;
		this.ringTone = ringTone;
	}

	public Long getAttentionId() {
		return attentionId;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public String getMessage() {
		return message;
	}

	public RingToneNotification getRingTone() {
		return ringTone;
	}
	
}

package com.expertaart.refactorapp.services.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.expertaart.refactorapp.services.dto.DeviceType;
import com.expertaart.refactorapp.services.dto.NotificationAttentionMessageDTO;
import com.expertaart.refactorapp.services.push.properties.WebSocketEndpointProperties;

@Service
public class MobileNotificationServiceImpl implements MobileNotificationService {

	@Autowired
	private SimpMessagingTemplate simpleMsgTemplate;
	
	@Autowired
	private WebSocketEndpointProperties webSocketEndpointProperties;

	public MobileNotificationServiceImpl(SimpMessagingTemplate simpleMsgTemplate) {
		this.simpleMsgTemplate = simpleMsgTemplate;
	}

	@Override
	public void pushMessage(NotificationAttentionMessageDTO notification, DeviceType deviceType) {
		//TODO send only to user that requested the attention
		switch (deviceType) {
		case ANDROID:
			simpleMsgTemplate.convertAndSend(webSocketEndpointProperties.getFullPushAndroid(), notification);
			break;
		case IOS:
			simpleMsgTemplate.convertAndSend(webSocketEndpointProperties.getFullPushIOS(), notification);
			break;
		}
	}

}

package com.expertaart.refactorapp.services.push;

import com.expertaart.refactorapp.services.dto.DeviceType;
import com.expertaart.refactorapp.services.dto.NotificationAttentionMessageDTO;

public interface MobileNotificationService {

	void pushMessage(NotificationAttentionMessageDTO notification, DeviceType deviceType);

}
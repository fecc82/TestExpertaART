package com.expertaart.refactorapp.services;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.expertaart.refactorapp.domain.Attention;
import com.expertaart.refactorapp.domain.AttentionStatus;
import com.expertaart.refactorapp.domain.Driver;
import com.expertaart.refactorapp.domain.DriverStatus;
import com.expertaart.refactorapp.repositories.AttentionRepository;
import com.expertaart.refactorapp.services.dto.NotificationAttentionMessageDTO;
import com.expertaart.refactorapp.services.dto.RingToneNotification;
import com.expertaart.refactorapp.services.push.MobileNotificationService;

@Service
public class AttentionServiceImpl implements AttentionService {

	@Autowired
	private AttentionRepository attentionRepository;

	@Autowired
	private DriverService driverService;
	
	@Autowired
	private MobileNotificationService mobileNotificationService;

	@Autowired
	private MessageSource messageSource;

	public AttentionServiceImpl() {
	}

	@Override
	public Optional<Attention> find(Long id) {
		return attentionRepository.findById(id);
	}
	
	@Override
	public List<Attention> findAll() {
		return attentionRepository.findAll();	
	}
	
	@Override
	public void processAttentionConfirmation(Attention attention, Long driverId) {
		Driver driver = driverService.find(driverId).get();
		driver.setDriverStatus(DriverStatus.UNAVAILABLE);
		attention.setDriver(driver);
		attention.setStatus(AttentionStatus.CONFIRMED);
		updateAttentionConfirmation(attention);
		notifyAttentionConfirmation(attention);
	}

	private void updateAttentionConfirmation(Attention attention) {
		attentionRepository.save(attention);
	}
	
	private void notifyAttentionConfirmation(Attention attention) {
		String message = messageSource.getMessage("ws.push.attention.confirm", null, Locale.getDefault());
		NotificationAttentionMessageDTO notif = new NotificationAttentionMessageDTO(attention.getId(),
				attention.getUser().getUuid(), message, RingToneNotification.DEFAULT);
		
		mobileNotificationService.pushMessage(notif, attention.getUser().getDeviceType());
	}


}

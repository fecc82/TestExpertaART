package com.expertaart.refactorapp.services.validators;

import com.expertaart.refactorapp.domain.Attention;
import com.expertaart.refactorapp.services.validators.exceptions.AttentionRequestValidatorsException;

public interface AttentionRequestValidatorService {

	Attention validatePostConfirm(Long attentionId, Long driverId) throws AttentionRequestValidatorsException;

}
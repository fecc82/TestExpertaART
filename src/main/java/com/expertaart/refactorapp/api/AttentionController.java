package com.expertaart.refactorapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expertaart.refactorapp.api.dto.PostConfirmResponseDTO;
import com.expertaart.refactorapp.domain.Attention;
import com.expertaart.refactorapp.services.AttentionService;
import com.expertaart.refactorapp.services.validators.AttentionErrorCode;
import com.expertaart.refactorapp.services.validators.AttentionRequestValidatorService;
import com.expertaart.refactorapp.services.validators.exceptions.AttentionRequestValidatorsException;

@RestController
@RequestMapping("/attention")
public class AttentionController {

	private final AttentionService attentionService;

	private final AttentionRequestValidatorService attentionRequestValidatorService;
	
	@Autowired
	public AttentionController(AttentionService attentionService,
			AttentionRequestValidatorService attentionRequestValidatorService) {
		this.attentionService = attentionService;
		this.attentionRequestValidatorService = attentionRequestValidatorService;
	}

	@GetMapping
	public ResponseEntity<List<Attention>> list() {
		return ResponseEntity.ok(attentionService.findAll());
	}
	
	@GetMapping("/postconfirm")
    public ResponseEntity<PostConfirmResponseDTO> postConfirm(@RequestParam("attentionId") Long attentionId, @RequestParam(name="driverId",required=true) Long driverId){
    	Attention attention = null;
    	try {
    		attention = attentionRequestValidatorService.validatePostConfirm(attentionId, driverId);
		} catch (AttentionRequestValidatorsException e) {
			return ResponseEntity.badRequest().body(new PostConfirmResponseDTO(AttentionErrorCode.valueOf(e.getMessage())));
		}
    	attentionService.processAttentionConfirmation(attention, driverId);
    	return ResponseEntity.ok(new PostConfirmResponseDTO(AttentionErrorCode.NONE));
    }

}

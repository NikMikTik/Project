package com.campaign.exception;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.campaign.dto.ResponseDto;


@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	ResponseDto response = new ResponseDto();
	String noToken = "******";

	@ExceptionHandler(Exception.class)
	public Exception blogError(Exception exception) {
		logger.error("Error Ocurred :~ " + exception.getMessage());
		return exception;
	}

	@ExceptionHandler(CampaignException.class)
	public Exception blogError(CampaignException exception) {
		logger.info("Error Ocurred :: " + exception.getMessage());
		return exception;
	}

	@ExceptionHandler(SQLException.class)
	public Exception sqlerror(Exception exception) {
		logger.error("Error Ocurred ~~ " + exception.getMessage());
		return exception;
	}

}

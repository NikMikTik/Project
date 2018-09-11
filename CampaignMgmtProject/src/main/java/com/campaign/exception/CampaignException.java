package com.campaign.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CampaignException extends RuntimeException{

	Logger logger = LoggerFactory.getLogger(CampaignException.class);

	public CampaignException(String message) {
		super(message);
		logger.info(message);
	}

	

}

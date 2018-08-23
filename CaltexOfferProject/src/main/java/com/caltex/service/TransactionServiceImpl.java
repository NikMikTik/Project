package com.caltex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.caltex.model.Customer;
import com.caltex.repository.CustomerRepository;

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	 @Scheduled(cron = "2 * * * * *")
	 public void scheduledTask() {
	 Iterable<Customer> userList = customerRepository.findAll();
	 
	
	 for (User user : userList) {
	 user.setPassword(password);
	 userRepository.save(user);
	
	 }
	
	 try {
	 mailJet.sendMail(userList, password);
	 } catch (MailjetException e) {
	 logger.info("Mailjet exception");
	 } catch (MailjetSocketTimeoutException e) {
	
	 logger.info("MailjetSocketTimeoutException");
	 }
	 }

}

package com.batch.writer;


import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import com.batch.model.User;
import com.batch.repository.UserRepository;
@Configuration
public class Writer {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private JavaMailSender sender;

	@Bean
	public RepositoryItemWriter<User> repositoryItemWriter() {
		RepositoryItemWriter<User> writer = new RepositoryItemWriter<>();
		writer.setRepository(userRepository);
		writer.setMethodName("save");
		return writer;

	}

}

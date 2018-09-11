package com.batch.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.model.User;
import com.batch.repository.UserRepository;

@Configuration
public class Reader {
	
	@Autowired
	UserRepository userRepository;


	@Bean
	@StepScope
	public RepositoryItemReader<User> repositoryItemReader() throws Exception {
		RepositoryItemReader<User> repositoryItemReader=new RepositoryItemReader<>();
		repositoryItemReader.setRepository(userRepository);
		repositoryItemReader.setMethodName("findAll");
		repositoryItemReader.afterPropertiesSet();
		return repositoryItemReader;
		
	}
    
}

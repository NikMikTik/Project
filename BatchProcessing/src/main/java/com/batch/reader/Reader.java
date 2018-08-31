package com.batch.reader;

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
	public RepositoryItemReader<User> repositoryItemReader() {
		RepositoryItemReader<User> repositoryItemReader=new RepositoryItemReader<>();
		repositoryItemReader.setRepository(userRepository);
		repositoryItemReader.setMethodName("findAll");
		return repositoryItemReader;
		
	}
    
}

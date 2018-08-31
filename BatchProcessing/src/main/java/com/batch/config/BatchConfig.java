package com.batch.config;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.model.User;
import com.batch.repository.UserRepository;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	
	@Autowired
	UserRepository userRepository;

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			RepositoryItemReader<User> itemReader, RepositoryItemWriter<User> itemWriter,
			ItemProcessor<User, User> itemProcessor) {
		Step step1 = stepBuilderFactory.get("ETL-Database-Load").<User, User>chunk(2).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();
		return jobBuilderFactory.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step1).build();
	}

	/*
	 * @Bean public Job job() { return
	 * jobBuilderFactory.get("ETL-Job").start(step()).build();
	 * 
	 * }
	 * 
	 * @Bean public Step step(ItemProcessor<User,User> itemProcessor){ return
	 * stepBuilderFactory.get("ETL-Step").chunk(2).reader(reader.
	 * repositoryItemReader()).processor(itemProcessor).writer(writer.
	 * repositoryItemWriter()).build();
	 * 
	 * }
	 */

}

package com.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.batch.dto.ResponseDto;
import com.batch.model.User;
import com.batch.repository.UserRepository;


@RestController
public class JobInvokerController {

	@Autowired
	JobLauncher jobLauncher;
	
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	Job job;
	
	ResponseDto response=new ResponseDto();

	@RequestMapping("/invokejob")
	public String handle() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(job, jobParameters);
		return "Batch job has been invoked";
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ResponseDto signUp(@RequestBody User user) {
		userRepository.save(user);
		response.setCode(201);
		response.setMessage("Created successfully");
		return response;

	}

}

package com.batch.listener;

import javax.batch.runtime.BatchStatus;
import javax.batch.runtime.JobExecution;

import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobListener extends JobExecutionListenerSupport{

	
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getBatchStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}
}

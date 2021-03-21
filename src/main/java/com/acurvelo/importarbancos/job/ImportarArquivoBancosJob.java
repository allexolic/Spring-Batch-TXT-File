package com.acurvelo.importarbancos.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class ImportarArquivoBancosJob {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Bean
	public Job importarArquivoJob(Step lerArquivoBancos) {
		return jobBuilderFactory
				.get("importarArquivoBancosJob")
				.start(lerArquivoBancos)
				.incrementer(new RunIdIncrementer())
				.build();
		
	}
}

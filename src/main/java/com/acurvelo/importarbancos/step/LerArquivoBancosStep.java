package com.acurvelo.importarbancos.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LerArquivoBancosStep {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step lerArquivoStep(FlatFileItemReader lerArquivoBancos,
			ItemWriter escreverBancosDB) {
		return stepBuilderFactory
				.get("lerArquivoBancosStep")
				.chunk(1)
				.reader(lerArquivoBancos)
				.writer(escreverBancosDB)
				.build();
	}
}

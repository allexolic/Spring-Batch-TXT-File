package com.acurvelo.importarbancos.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.acurvelo.importarbancos.model.Banco;

@Configuration
public class LerArquivoBancosReader {

	@StepScope
	@Bean
	public FlatFileItemReader<Banco> lerArquivoBancos(
			@Value("#{jobParameters['file']}") Resource resource) {
		return new FlatFileItemReaderBuilder<Banco>()
				.name("lerArquivoBancos")
				.resource(resource)
				.encoding("UTF-8")
				.delimited()
				.names(new String [] { "codigo", "nome", "webSite" })
				.targetType(Banco.class)
				.build();
		
	}
}

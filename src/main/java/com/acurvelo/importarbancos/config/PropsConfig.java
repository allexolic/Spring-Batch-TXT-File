package com.acurvelo.importarbancos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer config() {
		PropertySourcesPlaceholderConfigurer configure = new PropertySourcesPlaceholderConfigurer();
		configure.setLocation(new FileSystemResource("c:/springBatchConfig/application.properties"));
		configure.setIgnoreResourceNotFound(true);
		return configure;
	}
}

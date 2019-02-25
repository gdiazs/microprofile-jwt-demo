package io.gdiazs.mybank.commons.application;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
class ApplicationConfig {

	@Bean
	public ApplicationMenuOptions menuOptions() throws IOException {
		ClassPathResource classPathResource = new ClassPathResource("config/menu-options.json");
		ObjectMapper mapper = new ObjectMapper();
		ApplicationMenuOptions menuOptions = mapper.readValue(classPathResource.getInputStream(), ApplicationMenuOptions.class);
		return menuOptions;

	}
}

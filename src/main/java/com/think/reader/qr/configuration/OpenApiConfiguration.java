package com.think.reader.qr.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfiguration {
	
	private final OpenApiConfigurationProperties properties;
	
//	@Bean
//    public OpenAPI openApi() {
//		return new OpenAPI()
//	            .info(new Info()
//	                .title(properties.getTitle())
//	                .version(properties.getVersion())
//	                .description(properties.getDescription()));
//	}
	
}

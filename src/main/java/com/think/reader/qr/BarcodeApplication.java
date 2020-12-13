package com.think.reader.qr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BarcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarcodeApplication.class, args);
	}

}

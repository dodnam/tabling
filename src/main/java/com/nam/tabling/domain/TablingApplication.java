package com.nam.tabling.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class TablingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TablingApplication.class, args);
	}

}

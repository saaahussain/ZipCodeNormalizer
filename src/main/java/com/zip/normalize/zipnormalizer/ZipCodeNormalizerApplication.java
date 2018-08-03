package com.zip.normalize.zipnormalizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring boot 2.0.4 application
 * @author shussain
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = { 
	    SecurityAutoConfiguration.class 
	})
@ComponentScan(basePackages="com.zip")
public class ZipCodeNormalizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipCodeNormalizerApplication.class, args);
	}
}

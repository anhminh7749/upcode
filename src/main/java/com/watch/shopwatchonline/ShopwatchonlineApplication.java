package com.watch.shopwatchonline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.watch.shopwatchonline.Service.StogareService;
import com.watch.shopwatchonline.config.StorageProperties;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ShopwatchonlineApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ShopwatchonlineApplication.class, args);
	}
	 @Bean
	 CommandLineRunner init(StogareService service) {
	 	return (args -> {
	 		service.init();
	 	});
	 }
	 @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	  return builder.sources(ShopwatchonlineApplication.class);
	}
  
}

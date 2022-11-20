package com.watch.shopwatchonline;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.watch.shopwatchonline.Service.StogareService;
import com.watch.shopwatchonline.config.StorageProperties;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ShopwatchonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopwatchonlineApplication.class, args);
	}
	 @Bean
	 CommandLineRunner init(StogareService service) {
	 	return (args -> {
	 		service.init();
	 	});
	 }
}

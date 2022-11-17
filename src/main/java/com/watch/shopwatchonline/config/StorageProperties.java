package com.watch.shopwatchonline.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties("storage")
@Data
public class StorageProperties {
	private String location;

}

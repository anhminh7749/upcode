package com.watch.shopwatchonline.Domain;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MailRequest {
	private String to;
	private String subject;
	private String body;
	private Map<String, String> params;
}

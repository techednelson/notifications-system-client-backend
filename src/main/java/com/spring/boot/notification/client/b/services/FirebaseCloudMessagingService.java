package com.spring.boot.notification.client.b.services;

import com.spring.boot.notification.client.b.dto.SubscriptionRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@Service
public class FirebaseCloudMessagingService {

	private final Logger logger = LoggerFactory.getLogger(FirebaseCloudMessagingService.class);
	private final RestTemplate restTemplate;
	private final Environment environment;

	public FirebaseCloudMessagingService(RestTemplate restTemplate, Environment environment) {
		this.restTemplate = restTemplate;
		this.environment = environment;
	}

	public String subscribeToTopic(SubscriptionRequestDto subscriptionRequestDto) {
		HttpEntity<SubscriptionRequestDto> body = new HttpEntity<>(subscriptionRequestDto);
		ResponseEntity<String> response = this.restTemplate.exchange(Objects.requireNonNull(this.environment.getProperty("subscribeTopic")), HttpMethod.POST, body, String.class);
		logger.info(response.getBody());
		return response.getBody();
	}

	public String unsubscribeFromTopic(SubscriptionRequestDto subscriptionRequestDto) {
		HttpEntity<SubscriptionRequestDto> body = new HttpEntity<>(subscriptionRequestDto);
		ResponseEntity<String> response = this.restTemplate.exchange(Objects.requireNonNull(this.environment.getProperty("unsubscribeTopic")), HttpMethod.POST, body, String.class);
		logger.info(response.getBody());
		return response.getBody();
	}

}

package com.spring.boot.notification.client.b.controllers;

import com.spring.boot.notification.client.b.dto.SubscriptionRequestDto;
import com.spring.boot.notification.client.b.services.FirebaseCloudMessagingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class FirebaseCloudMessagingRestController {

	private final FirebaseCloudMessagingService firebaseCloudMessagingService;

	public FirebaseCloudMessagingRestController(FirebaseCloudMessagingService firebaseCloudMessagingService) {
		this.firebaseCloudMessagingService = firebaseCloudMessagingService;
	}

	@PostMapping("/subscribe")
	public String subscribeToTopic(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
		return this.firebaseCloudMessagingService.subscribeToTopic(subscriptionRequestDto);
	}

	@PostMapping("/unsubscribe")
	public String unsubscribeFromTopic(SubscriptionRequestDto subscriptionRequestDto) {
		return this.firebaseCloudMessagingService.unsubscribeFromTopic(subscriptionRequestDto);
	}

}

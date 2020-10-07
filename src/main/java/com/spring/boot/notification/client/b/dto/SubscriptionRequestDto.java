package com.spring.boot.notification.client.b.dto;

import java.io.Serializable;
import java.util.List;

public class SubscriptionRequestDto implements Serializable {

	private static final long serialVersionUID = -8648306964365505061L;

	String topicName;
	List<String> tokens;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<String> getTokens() {
		return tokens;
	}

	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
}

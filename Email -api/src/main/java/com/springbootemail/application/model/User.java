package com.springbootemail.application.model;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String to;
	private String subject;
	private String body;

	private String from;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User() {
	}

	public User(String to, String subject, String body) {
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public String toString() {
		return "User{" +
				"to='" + to + '\'' +
				", subject='" + subject + '\'' +
				", body='" + body + '\'' +
				'}';
	}
}

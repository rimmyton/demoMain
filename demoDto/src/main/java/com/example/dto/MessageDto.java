package com.example.dto;

import java.util.Date;

public class MessageDto {

	private Long id;

	private AccountDto receiver;

	private String message;

	private Date receiveDate;

	public MessageDto() {

	}

	public MessageDto(AccountDto receiver, String message, Date receiveDate) {
		this.receiver = receiver;
		this.message = message;
		this.receiveDate = receiveDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountDto getReceiver() {
		return receiver;
	}

	public void setReceiver(AccountDto receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}

	
	
}

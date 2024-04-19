package com.example.demo.response;

public class ResponeMessage {

	private String status;
	private String statusType;
	public ResponeMessage(String status, String statusType) {
		super();
		this.status = status;
		this.statusType = statusType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	@Override
	public String toString() {
		return "ResponeMessage [status=" + status + ", statusType=" + statusType + "]";
	}
}

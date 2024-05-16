package com.adbms.fleetXpress.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_code")
public class StatusCodes {
	
	@Id
	@Column(name="statuscode")
	private String statusCode;
	
	@Column(name="status")
	private String Status;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	

}

package com.bossy.myrestapiapp.application.dto;

import java.util.Date;

public class SubjectResponseDto {

	private String id;

	private String value;

	private String label;

	private Date creationDate;

	private Date lastUpdatedDate;

	public SubjectResponseDto(final String id, final String value, final String label, final Date creationDate,
			final Date lastUpdatedDate) {
		this.id = id;
		this.value = value;
		this.label = label;
		this.creationDate = creationDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}

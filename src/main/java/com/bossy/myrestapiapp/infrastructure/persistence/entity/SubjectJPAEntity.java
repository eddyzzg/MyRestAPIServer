package com.bossy.myrestapiapp.infrastructure.persistence.entity;

import java.util.Date;

import com.bossy.myrestapiapp.domain.model.SubjectPOJO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class SubjectJPAEntity {

	@Id
	private String id;
	private String label;
	private String value;

	private Date creationDate;
	private Date lastUpdatedDate;

	public SubjectJPAEntity() {
	}

	public SubjectJPAEntity(final String id, final String value, final String label, final Date creaDate,
			final Date lasDate) {
		this.id = id;
		this.value = value;
		this.label = label;
		this.creationDate = creaDate;
		this.lastUpdatedDate = lasDate;
	}

	static public SubjectJPAEntity fromDomain(SubjectPOJO subjectPOJO) {
		return new SubjectJPAEntity(subjectPOJO.getId(), subjectPOJO.getValue(), subjectPOJO.getLabel(),
				subjectPOJO.getCreationDate(), subjectPOJO.getLastUpdatedDate());
	}

	public SubjectPOJO toDomain() {
		return new SubjectPOJO(this.id, this.value, this.label, this.creationDate, this.lastUpdatedDate);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

package com.bossy.myrestapiapp.domain.model;

import java.util.Date;
import java.util.UUID;

public class SubjectPOJO {
	private String id;
	private String label;
	private String value;
	private Date creationDate;
	private Date lastUpdatedDate;

	// Prywatny ??? konstruktor dla rekonstukcji (używany przez repozytorium)
	public SubjectPOJO(String id, String value, String label, Date creationDate, Date lastUpdatedDate) {
		this.id = id;
		this.value = value;
		this.label = label;
		this.creationDate = creationDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}

	// Metoda fabrykująca dla tworzenia nowej encji
	public static SubjectPOJO createNew(String value, String label) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
		Date now = new Date();
		return new SubjectPOJO(UUID.randomUUID().toString(), value, label, now, now);
	}

	// Metoda biznesowa do aktualizacji opisu tematu
	public void updateValue(String newValue) {
		if (newValue == null || newValue.isBlank()) {
			throw new IllegalArgumentException("Description cannot be empty.");
		}
		this.value = newValue;
		this.lastUpdatedDate = new Date();
	}

	// Gettery
	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getValue() {
		return value;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	// Statyczna metoda do konwersji z JPA Entity na domenową (POJO)
	public static SubjectPOJO from(String id, String name, String description, Date creationDate,
			Date lastUpdatedDate) {
		return new SubjectPOJO(id, name, description, creationDate, lastUpdatedDate);
	}
}

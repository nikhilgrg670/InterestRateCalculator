package com.macquarie.niks.model;

import java.io.Serializable;

import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7624028002217249099L;

	@Id
	@GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES, delimiter = "::")
	private String key;
	
	@Version
	private long cas;
	
	@Field
	private String created;
	
	@Field
	private String updated;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getCas() {
		return cas;
	}

	public void setCas(long cas) {
		this.cas = cas;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
}

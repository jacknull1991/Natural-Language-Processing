package com.jacknull.nlp.nli.model.config;

import java.util.Properties;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class DBConnectionConfig {
	String host;
	String port;
	String database;
	String username;
	String password;
	
	@JsonIgnore
	public String getUrl() {
		return "jdbc:postgresql://" + host + ":" + port + "/" + database;
	}
	
	@JsonIgnore
	public Properties getProperties() {
		Properties props = new Properties();
		props.setProperty("user", username);
		props.setProperty("password", password);
		return props;
	}
}

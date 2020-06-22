package com.jacknull.nlp.nli.model.config;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSession {
	
	@JsonUnwrapped
	private DBConnectionConfig dbConnectionConfig;
	
	public String serialize() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(this);
	}
	
	public static UserSession deserialize(String str) throws IOException {
		return new ObjectMapper().readValue(str, UserSession.class);
	}
}

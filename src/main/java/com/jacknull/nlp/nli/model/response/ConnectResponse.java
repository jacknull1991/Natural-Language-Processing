package com.jacknull.nlp.nli.model.response;

import lombok.Value;

@Value
public class ConnectResponse {
	boolean success;
	String databaseUrl;
}

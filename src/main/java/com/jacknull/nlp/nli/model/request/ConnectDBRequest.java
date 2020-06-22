package com.jacknull.nlp.nli.model.request;

import lombok.Value;

@Value
public class ConnectDBRequest {
	String host;
	String port;
	String database;
	String username;
	String password;
}

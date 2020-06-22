package com.jacknull.nlp.nli.model.response;

import lombok.Value;

@Value
public class StatusMessageResponse {
	boolean success;
	String message;
}

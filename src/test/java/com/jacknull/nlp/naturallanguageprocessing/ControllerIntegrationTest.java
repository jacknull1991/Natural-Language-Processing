package com.jacknull.nlp.naturallanguageprocessing;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	private URL base;

	@Autowired
	private TestRestTemplate template;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
	}
	
	@Test
	public void getIndex() throws Exception {
		ResponseEntity<String> res = template.getForEntity(base.toString(),
				String.class);
		assertThat(res.getBody()).isEqualTo("Welcome to Natural Language Interface");
	}
}

package com.jacknull.nlp.nli.controller;

import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jacknull.nlp.nli.model.config.DBConnectionConfig;
import com.jacknull.nlp.nli.model.config.UserSession;
import com.jacknull.nlp.nli.model.request.ConnectDBRequest;
import com.jacknull.nlp.nli.model.response.ConnectResponse;
import com.jacknull.nlp.nli.model.response.MessageResponse;
import com.jacknull.nlp.nli.model.service.CookieService;
import com.jacknull.nlp.nli.model.service.DBConnectionService;
import com.jacknull.nlp.nli.model.service.RedisService;
import com.jacknull.nlp.nli.model.service.SQLExecutionService;
import com.jacknull.nlp.nli.model.service.TranslationService;

@RestController
@RequestMapping("/api")
public class IndexController {
	
	private CookieService cookieService;
	private RedisService redisService;
	private DBConnectionService dbConnectionService;
	private SQLExecutionService sqlExecutionService;
	private TranslationService translationService;
	
	@Autowired
	public IndexController(
			CookieService cookieService,
			RedisService redisService,
			DBConnectionService dbConnectionService,
			SQLExecutionService sqlExecutionService,
			TranslationService translationService) {
		this.cookieService = cookieService;
        this.redisService = redisService;
        this.dbConnectionService = dbConnectionService;
        this.sqlExecutionService = sqlExecutionService;
        this.translationService = translationService;
	}
	
	/**
	 * For testing
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "Welcome to NLI";
	}


	/**
	 * Database connection request
	 */
	@RequestMapping("/connect/db")
	public ResponseEntity connectDB(@RequestBody ConnectDBRequest req,
			HttpServletResponse res) throws JsonProcessingException {
		DBConnectionConfig config = DBConnectionConfig.builder()
				.host(req.getHost())
				.port(req.getPort())
				.database(req.getDatabase())
				.username(req.getUsername())
				.password(req.getPassword())
				.build();
		
		try {
			dbConnectionService.getConnection(config);
			String userId = UUID.randomUUID().toString();
			UserSession session = new UserSession(config);
			// TODO: redis
			cookieService.setUserIdCookie(res, userId);
			return ResponseEntity.ok().body(new ConnectResponse(true, config.getUrl()));
		} catch (SQLException e) {
			// TODO: handle other exceptions
			return ResponseEntity.status(400).body(new MessageResponse("Connection Failed!"));
		}
	}
}

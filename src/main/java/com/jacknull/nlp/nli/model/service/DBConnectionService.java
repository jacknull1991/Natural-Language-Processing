package com.jacknull.nlp.nli.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.jacknull.nlp.nli.model.config.DBConnectionConfig;

@Service
public class DBConnectionService {
	public Connection getConnection(DBConnectionConfig config) throws SQLException {
		return DriverManager.getConnection(config.getUrl(), config.getProperties());
	}
}

package com.jacknull.nlp.nli.model.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacknull.nlp.nli.model.config.DBConnectionConfig;

@Service
public class SQLExecutionService {
	private DBConnectionService dbConnectionService;
	
	@Autowired
	public SQLExecutionService(DBConnectionService dbConnectionService) {
		this.dbConnectionService = dbConnectionService;
	}
	
	public String executeSQL(DBConnectionConfig config, String query) throws SQLException {
		try {
			Connection conn = dbConnectionService.getConnection(config);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int cols = rsmd.getColumnCount();
			StringBuilder sb = new StringBuilder();
			
			// construct table
			for (int i=1; i<cols; i++) {
				sb.append(rsmd.getColumnName(i)).append("\t");
			}
			sb.append("\n");
			
			while (rs.next()) {
				for (int i=1; i<cols; i++) {
					sb.append(rs.getString(i)).append("\t");
				}
				sb.append("\n");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return sb.toString();
		} catch (PSQLException e) {
			return e.getMessage();
		}
	}
}

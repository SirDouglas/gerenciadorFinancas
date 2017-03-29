package br.com.tiago.gerenciador.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());	
			return
DriverManager.getConnection("jdbc:mysql://localhost/fj21","root","vertrigo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new RuntimeException(e);
		}
		
	}
	
}

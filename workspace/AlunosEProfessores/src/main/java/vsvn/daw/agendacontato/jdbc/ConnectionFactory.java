package vsvn.daw.agendacontato.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String DB_NAME = "daw",
			URL = "jdbc:postgresql://localhost:5432/" + DB_NAME, 
			USER = "postgres",
			PASSWORD = "123456";
	
	public static Connection getConnection() {
		try {
			System.out.println(URL);
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(URL,USER, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Alouuuuuuu");
			e.printStackTrace();
			System.out.println("Alouuuuuuu");
		}
		return null;
		
	}
}

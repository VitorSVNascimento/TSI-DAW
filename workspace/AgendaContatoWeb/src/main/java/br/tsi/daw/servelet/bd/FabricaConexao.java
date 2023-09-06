package br.tsi.daw.servelet.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	public static Connection getConnection() {
		try {
			//Registro do Driver
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/agenda","postgres","123456");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

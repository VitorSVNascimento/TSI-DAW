package br.tsi.daw.tp1.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	public static Connection getConnection() {
		try {
			//Registro no BD
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/sistema","postgres","123456");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}

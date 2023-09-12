package vsvn.daw.alunoseprofessores.teste;

import java.sql.Connection;
import java.sql.SQLException;

import vsvn.daw.alunoseprofessores.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 try {
		 new ConnectionFactory();
		Connection connection = ConnectionFactory.getConnection(); 
		 System.out.println("Conexão aberta!");
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}

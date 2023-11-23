package br.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.tsi.daw.tp1.bd.FabricaConexao;
import br.tsi.daw.tp1.modelo.Medico;

public class MedicoDAO {
	private Connection connection;
	
	public MedicoDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public Medico validaDados(String crm, String senha) {
		String sql = "select * from medico where crm=? and senha=?";
		Medico medico = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1,crm);
			stmt.setString(2,senha);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				medico = new Medico();
				medico.setCrm(rs.getString("crm"));
				medico.setSenha(rs.getString("senha"));
				medico.setNome(rs.getString("nome"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return medico;
	}
	
	public Medico recuperaMedico(String crm) {
		String sql = "select * from medico where crm=?";
		Medico medico = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, crm);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				medico = new Medico();
				medico.setNome(rs.getString("nome"));
				medico.setCrm(rs.getString("crm"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return medico;
	}
	
}

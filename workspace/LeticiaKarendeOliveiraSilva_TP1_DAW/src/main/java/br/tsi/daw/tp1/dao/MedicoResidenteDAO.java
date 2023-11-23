package br.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.tsi.daw.tp1.bd.FabricaConexao;
import br.tsi.daw.tp1.modelo.MedicoResidente;

public class MedicoResidenteDAO {
	
	private Connection connection;
	
	public MedicoResidenteDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public MedicoResidente validaDados(String crm, String senha) {
		String sql = "select * from medico_residente where crm=? and senha=?";
		MedicoResidente medicoResidente = null;
		
		try(PreparedStatement stmt= connection.prepareStatement(sql)){
			stmt.setString(1, crm);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				medicoResidente = new MedicoResidente();
				medicoResidente.setCrm(rs.getString("crm"));
				medicoResidente.setSenha(rs.getString("senha"));
				medicoResidente.setNome(rs.getString("nome"));
				medicoResidente.setAnoInicio(rs.getInt("ano_inicio"));
				medicoResidente.setMatricula(rs.getString("matricula"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return medicoResidente;
	}
	
}

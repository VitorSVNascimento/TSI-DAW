package br.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.tsi.daw.tp1.bd.FabricaConexao;
import br.tsi.daw.tp1.modelo.MedicoDocente;

public class MedicoDocenteDAO {
	private Connection connection;
	
	public MedicoDocenteDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public MedicoDocente validaDados(String crm, String senha) {
		String sql = "select * from medico_docente where crm=? and senha=?";
		MedicoDocente medicoDocente = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1,crm);
			stmt.setString(2,senha);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				medicoDocente = new MedicoDocente();
				medicoDocente.setCrm(rs.getString("crm"));
				medicoDocente.setSenha(rs.getString("senha"));
				medicoDocente.setNome(rs.getString("nome"));
				medicoDocente.setTitulacao(rs.getString("titulacao"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return medicoDocente;
	}
	
}

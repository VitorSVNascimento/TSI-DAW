package vsvn.tsi.daw.cardio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import vsvn.tsi.daw.cardio.bd.FabricaConexao;
import vsvn.tsi.daw.cardio.enums.CategoriaMedico;
import vsvn.tsi.daw.cardio.modelo.Medico;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.*;

public class MedicoDAO {

	private Connection connection;
	
	public MedicoDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public List<Medico> listaMedico(){
		List<Medico> medicos = new ArrayList<Medico>();
		String sql = "SELECT crm,nome,categoria,titulacao,ano_inicio FROM medico";
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Medico medico = obterMedicoFromResultSet(rs);
				if(medico != null)
					medicos.add(medico);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return medicos;
	}
	
	private Medico obterMedicoFromResultSet(ResultSet rs) {
		try {
			Medico medico = new Medico();
			medico.setCrm(rs.getString(CRM));
			medico.setNome(rs.getString(NOME));
			medico.setCategoria(CategoriaMedico.fromDescricao(rs.getString(CATEGORIA)));
			medico.setTitulacao(rs.getString(TITULACAO));
			medico.setanoinicio(rs.getString(ANO_INICIO));
			return medico;
		}catch (SQLException execption) {
			execption.printStackTrace();
			return null;
		} 
	}
	
	public Medico validaCredencial(String crm, String senha) {
		String sql = "select * from medico where crm=? and senha=?";
//		System.out.println(String.format("crm = %s\nSenha = %s", crm,senha));
		Medico medico = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, crm);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				medico = obterMedicoFromResultSet(rs);
				medico.setSenha(rs.getString(SENHA));
			}
		} catch (SQLException e) {
		
		}
		System.out.println(medico.getCrm() + " " + medico.getSenha());
		return medico;
	}
	
	
}

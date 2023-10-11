package vsvn.tsi.daw.cardio.dao;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.CPF;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.DATA_NASCIMENTO;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.EMAIL;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.NOME;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.SEXO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import vsvn.tsi.daw.cardio.bd.FabricaConexao;
import vsvn.tsi.daw.cardio.modelo.Paciente;

public class PacienteDAO {
	private Connection connection;
	
	public PacienteDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public Paciente buscarPaciente(String cpf) {
		String sql = "select * from paciente where cpf=?";
		Paciente paciente = null;
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				paciente = obterPacienteFromResultSet(rs);
			}
		} catch (SQLException e) {
		
		}
		if(paciente != null)
			System.out.println(paciente.getCpf());
		return paciente;
	}
	
	private Paciente obterPacienteFromResultSet(ResultSet rs) {
		try {
			Paciente paciente = new Paciente();
			paciente.setCpf(rs.getString(CPF));
			paciente.setNome(rs.getString(NOME));
			paciente.setEmail(rs.getString(EMAIL));
			paciente.setSexo(rs.getString(SEXO));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate(DATA_NASCIMENTO));
			paciente.setDatanascimento(data);
			return paciente;
		}catch (SQLException execption) {
			execption.printStackTrace();
			return null;
		} 
	}
}

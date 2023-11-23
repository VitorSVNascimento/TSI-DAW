package br.tsi.daw.tp1.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoResidente extends Medico{
	
	private String matricula;
	private int anoInicio;
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public int getAnoInicio() {
		return anoInicio;
	}
	
	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}
	
	public static MedicoResidente criarMedico(ResultSet resultSet) throws SQLException {
        MedicoResidente medicoResidente = new MedicoResidente();
        medicoResidente.setNome(resultSet.getString("nome"));
        medicoResidente.setCrm(resultSet.getString("crm"));
        medicoResidente.setMatricula(resultSet.getString("matricula"));
        medicoResidente.setAnoInicio(resultSet.getInt("ano_inicio"));
        return medicoResidente;
    }
}

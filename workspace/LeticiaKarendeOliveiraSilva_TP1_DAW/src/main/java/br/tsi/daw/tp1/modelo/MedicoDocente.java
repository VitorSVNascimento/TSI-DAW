package br.tsi.daw.tp1.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicoDocente extends Medico {
	
	private String titulacao;

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
	public static MedicoDocente criarMedico(ResultSet resultSet) throws SQLException {
        MedicoDocente medicoDocente = new MedicoDocente();
        medicoDocente.setNome(resultSet.getString("nome"));
        medicoDocente.setCrm(resultSet.getString("crm"));
        medicoDocente.setTitulacao(resultSet.getString("titulacao"));
        return medicoDocente;
    }
	
}

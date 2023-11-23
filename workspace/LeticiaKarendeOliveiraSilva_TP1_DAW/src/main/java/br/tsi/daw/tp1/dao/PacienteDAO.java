package br.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.tsi.daw.tp1.bd.FabricaConexao;
import br.tsi.daw.tp1.modelo.Paciente;

public class PacienteDAO {
	private Connection connection;
	
	public PacienteDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	 public int calcularIdade(String dataNascimento) {
		 // Crie uma instância do SimpleDateFormat para analisar a data de nascimento
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        
	     try {
	    	 // Parse da data de nascimento para um objeto Date
	    	 Date dataNascimentoDate = sdf.parse(dataNascimento);
	            
	    	 // Crie uma instância de Calendar para a data de nascimento
	    	 Calendar calendarioNascimento = Calendar.getInstance();
	    	 calendarioNascimento.setTime(dataNascimentoDate);
	            
	    	 // Obtenha o ano, mês e dia de nascimento
	    	 int anoNascimento = calendarioNascimento.get(Calendar.YEAR);
	    	 int mesNascimento = calendarioNascimento.get(Calendar.MONTH);
	    	 int diaNascimento = calendarioNascimento.get(Calendar.DAY_OF_MONTH);
	            
	    	 // Obtenha o ano, mês e dia atuais
	    	 Calendar calendarioAtual = Calendar.getInstance();
	    	 int anoAtual = calendarioAtual.get(Calendar.YEAR);
	    	 int mesAtual = calendarioAtual.get(Calendar.MONTH);
	         int diaAtual = calendarioAtual.get(Calendar.DAY_OF_MONTH);
	            
	         // Calcule a idade considerando o ano, mês e dia de nascimento
	         int idade = anoAtual - anoNascimento;
	            
	         // Ajuste se o aniversário ainda não ocorreu este ano
	         if (mesAtual < mesNascimento || (mesAtual == mesNascimento && diaAtual < diaNascimento)) {
	        	 idade--;
	         }
	            
	         return idade;
	     } catch (Exception e) {
	    	 e.printStackTrace();
	    	 return 0;
	     }
	  }
	
	public Paciente recuperaPaciente(Paciente p) {
		String sql = "select * from paciente where cpf=?";
		Paciente paciente = null;
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, p.getCpf());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				paciente = new Paciente();
				paciente.setCpf(rs.getString("cpf"));
				paciente.setNome(rs.getString("nome"));
				paciente.setEmail(rs.getString("email"));
				paciente.setSexo(rs.getString("sexo"));
				paciente.setDataNascimento(rs.getString("data_nascimento"));
				paciente.setIdade(calcularIdade(paciente.getDataNascimento()));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}
}

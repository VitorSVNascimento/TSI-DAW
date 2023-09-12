package vsvn.daw.alunoseprofessores.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vsvn.daw.alunoseprofessores.jdbc.ConnectionFactory;
import vsvn.daw.alunoseprofessores.modelo.Professor;

public class ProfessorDAO {

	private Connection connection;
	
	public ProfessorDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Professor professor) {
		String sql = "INSERT INTO professores "
				+ "(nome, email, grau_formacao)" 
				+ "VALUES ( ?, ?, ?);";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			

			
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getEmail());
			stmt.setString(3, professor.getGrau_formacao());

			stmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	public void altera(Professor professor) {
		String sql = "UPDATE professores SET nome=?, email=?, grau_formacao=?"
				+ "where id=?;";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getEmail());
			stmt.setString(3, professor.getGrau_formacao());
			stmt.setLong(4, professor.getId());
			stmt.execute();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	public void remove (Professor professor) {
		String sql = "delete from professores where id=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, professor.getId());
			stmt.execute();
		} catch (SQLException e) {
			
		}		
	}
	
	public List<Professor> listaTodos(){
		List<Professor> professores = new ArrayList<>();
		String sql = "select * from professor";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getLong("id"));
				professor.setNome(rs.getString("nome"));
				professor.setEmail(rs.getString("email"));
				professor.setGrau_formacao(rs.getString("grau_formacao"));

				professores.add(professor);
				
			}
		} catch (SQLException e) {
		
		}	
		
		return professores;
	}
	
	
}

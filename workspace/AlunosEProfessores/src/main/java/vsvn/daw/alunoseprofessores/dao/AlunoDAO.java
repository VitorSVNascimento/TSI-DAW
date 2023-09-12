package vsvn.daw.alunoseprofessores.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vsvn.daw.alunoseprofessores.jdbc.ConnectionFactory;
import vsvn.daw.alunoseprofessores.modelo.Aluno;





public class AlunoDAO {

	private Connection connection;
	
	public AlunoDAO() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Aluno aluno) {
		String sql = "INSERT INTO alunos "
				+ "(nome, email, endereco, datanascimento)" 
				+ "VALUES ( ?, ?, ?,?);";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			

			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getEndereco());
			Date data = new Date(aluno.getDatanascimento().getTimeInMillis());
			stmt.setDate(4, data);
			System.out.println(stmt.execute());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	public void altera(Aluno aluno) {
		String sql = "UPDATE alunos SET nome=?, email=?, endereco=?, datanascimento=?"
				+ "where id=?;";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getEndereco());
			Date data = new Date(aluno.getDatanascimento().getTimeInMillis());
			stmt.setDate(4, data);
			stmt.setLong(5, aluno.getId());
			stmt.execute();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	public void remove (Aluno aluno) {
		String sql = "delete from alunos where id=?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, aluno.getId());
			stmt.execute();
		} catch (SQLException e) {
		}		
	}
	
	
	public List<Aluno> getListaAluno(){
		List<Aluno> alunos = new ArrayList<>();
		String sql = "select * from alunos";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getLong("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				aluno.setDatanascimento(data);
				alunos.add(aluno);
			}
		} catch (SQLException e) {
		
		}	
		
		return alunos;
	}
	

}

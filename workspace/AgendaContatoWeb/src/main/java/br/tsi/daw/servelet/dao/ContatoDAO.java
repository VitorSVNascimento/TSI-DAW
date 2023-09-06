package br.tsi.daw.servelet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.tsi.daw.servelet.bd.FabricaConexao;
import br.tsi.daw.servelet.modelo.Contato;

public class ContatoDAO {
private Connection connection;
	
	public ContatoDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contato (nome,email,endereco,datanascimento) values (?,?,?,?)";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setString(1,contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			Date data = new Date(contato.getDataNascimento().getTimeInMillis());
			stm.setDate(4, data);
			stm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contato set nome=?, email=?,endereco=?,datanascimento=? where id=?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setString(1,contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			Date data = new Date(contato.getDataNascimento().getTimeInMillis());
			stm.setDate(4, data);
			stm.setLong(5, contato.getId());
			stm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(Contato contato) {
		String sql = "delete from contato where id=?";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setLong(1, contato.getId());
			stm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Contato> listaConatos(){
		List<Contato> contatos = new ArrayList<>();
		
		String sql = "select * from contato";
		
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Contato contato = obterContato(rs);
				if(contato != null)
					contatos.add(contato);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return contatos;
	}
	
	public Contato Pesquisar(int id) {
		
		String sql = "select * from contato WHERE id=?";
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			rs.next();
			Contato contato = obterContato(rs);
			return contato;
			
		}catch (SQLException e) {
			return null;
		}
		
		
	}
	
	private Contato obterContato(ResultSet rs) {
		try {
			
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("datanascimento"));
			contato.setDataNascimento(data);
			return contato;
		}catch (SQLException execption) {
			execption.printStackTrace();
			return null;
		}
	}
}

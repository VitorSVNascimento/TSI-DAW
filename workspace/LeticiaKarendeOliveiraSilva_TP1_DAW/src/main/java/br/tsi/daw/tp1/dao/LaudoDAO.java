package br.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.tsi.daw.tp1.bd.FabricaConexao;
import br.tsi.daw.tp1.modelo.Laudo;
import br.tsi.daw.tp1.modelo.PedidoExame;

public class LaudoDAO{
	private Connection connection;
	
	public LaudoDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public void adicionaLaudo(Laudo laudo) {
		String sql = "insert into laudo (descricao, conclusao, status, id_pedido_exame) values (?, ?, ?, ?) ";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, laudo.getDescricao());
			stmt.setString(2, laudo.getConclusao());
			stmt.setString(3, laudo.getStatus());
			stmt.setInt(4, laudo.getPedidoExame().getId());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Laudo>laudosParaAvaliar(){
		String sql = "select * from laudo";
		List<Laudo>laudos = new ArrayList<Laudo>();
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("status").equals("provisorio")) {
					Laudo laudo = new Laudo();
					laudo.setId(rs.getInt("id"));
					laudo.setDescricao(rs.getString("descricao"));
					laudo.setConclusao(rs.getString("conclusao"));
					laudo.setStatus(rs.getString("status"));
					PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
					PedidoExame pedidoExame = pedidoExameDAO.obterPedidoExamePorId(rs.getInt("id_pedido_exame"));
					laudo.setPedidoExame(pedidoExame);
					laudos.add(laudo);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return laudos;
	}
	
	public Laudo obterLaudoPorId(int id) {
		String sql = "select * from laudo where id=?";
		Laudo laudo = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				laudo = new Laudo();
				laudo.setConclusao(rs.getString("conclusao"));
				laudo.setDescricao(rs.getString("descricao"));
				laudo.setStatus(rs.getString("status"));
				laudo.setId(rs.getInt("id"));
				PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
				PedidoExame pedidoExame = new PedidoExame();
				pedidoExame = pedidoExameDAO.obterPedidoExamePorId(rs.getInt("id_pedido_exame"));
				laudo.setPedidoExame(pedidoExame);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return laudo;
	}
	
	public void alterandoStatus(String novoStatus, int id) {
		String sql = "update laudo set status=? where id=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, novoStatus);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Laudo> listaLaudosPaciente(String cpf){
		String sql = "select * from laudo";
		List<Laudo>laudos = new ArrayList<Laudo>();
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("status").equals("definitivo")) {
					PedidoExame pedidoExame = new PedidoExame();
					PedidoExameDAO pedidoExameDAO = new PedidoExameDAO();
					pedidoExame = pedidoExameDAO.obterPedidoExamePorId(rs.getInt("id_pedido_exame"));
					if(pedidoExame != null) {
						if(pedidoExame.getPaciente().getCpf().equals(cpf)) {
							System.out.println(cpf);
							Laudo laudo = new Laudo();
							laudo.setConclusao(rs.getString("conclusao"));
							laudo.setDescricao(rs.getString("descricao"));
							laudo.setStatus(rs.getString("status"));
							laudo.setId(rs.getInt("id"));
							laudo.setPedidoExame(pedidoExame);
							laudos.add(laudo);
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return laudos;
	}
}

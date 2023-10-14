package vsvn.tsi.daw.cardio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vsvn.tsi.daw.cardio.bd.FabricaConexao;
import vsvn.tsi.daw.cardio.enums.SituacaoLaudo;
import vsvn.tsi.daw.cardio.modelo.Exame;
import vsvn.tsi.daw.cardio.modelo.Laudo;

public class LaudoDAO {
	private Connection connection;
	
	public LaudoDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public boolean insert(Laudo laudo) {
		
		String sql = "INSERT INTO laudo (id_exame,situacao,descricao,conclusao,imagens_path,crm) VALUES (?,?,?,?,?,?)";
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setLong(1, laudo.getId_exame());
			stm.setString(2, laudo.getSituacao().getSituacao());
			stm.setString(3, laudo.getDescricao());
			stm.setString(4, laudo.getConclusao());
			stm.setString(5, laudo.getImages_path());
			stm.setString(6, laudo.getCrm());
			stm.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Laudo> getLaudoPorSituacao(SituacaoLaudo situacao){
		return getLaudosPorFiltro(String.format("SELECT * FROM laudo WHERE situacao='%s'", situacao.getSituacao()));
	}
	
	private List<Laudo> getLaudosPorFiltro(String sql) {
	  List<Laudo> laudos = new ArrayList<Laudo>();
	  try (PreparedStatement stm = connection.prepareStatement(sql)) {
	        ResultSet rs = stm.executeQuery();
	        while (rs.next()) {
	            Laudo laudo = obterLaudoFromResultSet(rs);
	            if (laudo != null)
	                laudos.add(laudo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	  return laudos;
	}
	
	public Laudo obterLaudoFromResultSet(ResultSet rs) {
		return null;
	}
	
}

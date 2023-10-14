package vsvn.tsi.daw.cardio.dao;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.CONCLUSAO;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.CRM;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.DESCRICAO;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.ID;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.ID_EXAME;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.IMAGENS_PATH;
import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.SITUACAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vsvn.tsi.daw.cardio.bd.FabricaConexao;
import vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas;
import vsvn.tsi.daw.cardio.enums.SituacaoLaudo;
import vsvn.tsi.daw.cardio.modelo.Laudo;

public class LaudoDAO {
	private Connection connection;
	
	public LaudoDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public boolean insert(Laudo laudo) {
		
		String sql = "INSERT INTO laudo (id_exame,situacao,descricao,conclusao,imagens_path,crm) VALUES (?,?,?,?,?,?)";
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			
			stm.setLong(1, laudo.getExame().getId());
			stm.setString(2, laudo.getSituacao().getSituacao());
			stm.setString(3, laudo.getDescricao());
			stm.setString(4, laudo.getConclusao().getCodigo());
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
	
	public List<Laudo> getLaudosDefinitivosDoPaciente(String cpf) {
		
		return getLaudosPorFiltro(String.format("SELECT l.* FROM laudo AS l JOIN exame AS e ON l.id_exame = e.id WHERE e.cpf = '%s' AND l.situacao = '%s'; ", cpf,SituacaoLaudo.DEFINITIVO.getSituacao()));
		
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
		try {
			
			Laudo laudo = new Laudo();
			
			
			laudo.setConclusao(HipotesesDiagnosticas.fromCodigo(rs.getString(CONCLUSAO)));
			laudo.setCrm(rs.getString(CRM));
			laudo.setDescricao(rs.getString(DESCRICAO));
			laudo.setId(rs.getLong(ID));
			laudo.setExame(new ExameDAO().getExameByID(rs.getLong(ID_EXAME)));
			laudo.setImages_path(rs.getString(IMAGENS_PATH));
			laudo.setSituacao(SituacaoLaudo.getSituacaoLaudoFromString(rs.getString(SITUACAO)));
			return laudo;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean autorizarLaudo(Long id) {
		String sql = "UPDATE laudo SET situacao=? WHERE id=?";
		try (PreparedStatement stm = connection.prepareStatement(sql)) {
			stm.setString(1, SituacaoLaudo.DEFINITIVO.getSituacao());
			stm.setLong(2, id);
			
			stm.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
}

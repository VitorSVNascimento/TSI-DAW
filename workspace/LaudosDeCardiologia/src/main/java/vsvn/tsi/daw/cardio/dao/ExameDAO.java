package vsvn.tsi.daw.cardio.dao;

import static vsvn.tsi.daw.cardio.constantes.AtributosTabela.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vsvn.tsi.daw.cardio.bd.FabricaConexao;
import vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas;
import vsvn.tsi.daw.cardio.enums.SituacaoExame;
import vsvn.tsi.daw.cardio.enums.TiposDeExames;
import vsvn.tsi.daw.cardio.modelo.Exame;

public class ExameDAO {
	private Connection connection;
	
	public ExameDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	
	public boolean inserir(Exame exame) {
		String sql = "INSERT INTO exame (datapedido,tipo,hipotese,crm,cpf,situacao) VALUES (?,?,?,?,?,?)";
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			Date data = new Date(exame.getDatapedido().getTimeInMillis());
			
			stm.setDate(1, data);
			stm.setString(2, exame.getTipo().getDescricao());
			stm.setString(3, exame.getHipotese().getCodigo());
			stm.setString(4, exame.getCrm());
			stm.setString(5, exame.getCpf());
			stm.setString(6, SituacaoExame.AGUARDANDO_EXAME.getDescricao());
			stm.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Exame> getExamesDoPaciente(TiposDeExames tipo, String cpfPaciente) {
		List<Exame> exames = new ArrayList<Exame>();
		
		String sql = "SELECT * FROM exame WHERE tipo=? and cpf=?";
		try(PreparedStatement stm = connection.prepareStatement(sql)){
			stm.setString(1, tipo.getDescricao());
			stm.setString(2, cpfPaciente);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Exame exame =  obterExameFromResultSet(rs);
				if(exame != null)
					exames.add(exame);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return exames;
		
		
	}


	public Exame obterExameFromResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		
			try {
				Exame exame = new Exame();
				exame.setCpf(rs.getString(CPF));
				exame.setCrm(rs.getString(CRM));
				exame.setHipotese(HipotesesDiagnosticas.fromCodigo(rs.getString(HIPOTESE)));
				exame.setSituacao(SituacaoExame.getSituacaoExameFromString(rs.getString(SITUACAO)));
				exame.setId(rs.getLong(ID));
				exame.setTipo(TiposDeExames.getTipoDeExameFromDescricao(rs.getString(TIPO)));
				
				Calendar data_pedido = Calendar.getInstance();
				data_pedido.setTime(rs.getDate(DATA_PEDIDO));
				exame.setDatapedido(data_pedido);
				
				if(exame.getSituacao() == SituacaoExame.LAUDO_REALIZADO)
					exame.setData_e_hora_realizacao(getDataHoraRealizacao(rs));
				else
					exame.setData_e_hora_realizacao(null);
				
				
				return exame;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
	}
	
	private Calendar getDataHoraRealizacao(ResultSet rs) {
		Timestamp stamp;
		try {
			stamp = rs.getTimestamp(DATA_E_HORA_REALIZACAO);
			if(stamp==null)
				return null;
			Calendar data_hora_realizacao = Calendar.getInstance();
			data_hora_realizacao.setTimeInMillis(stamp.getTime());
			return data_hora_realizacao;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean verificarExameEmAguardo(List<Exame> exames) {
		
		for(Exame exame : exames) {
			if(exame.getSituacao() == SituacaoExame.AGUARDANDO_EXAME)
				return true;
		}
		return false;
		
	}

}

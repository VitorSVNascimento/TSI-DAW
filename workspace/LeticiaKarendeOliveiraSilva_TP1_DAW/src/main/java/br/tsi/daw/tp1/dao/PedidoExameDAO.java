package br.tsi.daw.tp1.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.tsi.daw.tp1.bd.FabricaConexao;
import br.tsi.daw.tp1.modelo.EnviaEmail;
import br.tsi.daw.tp1.modelo.Medico;
import br.tsi.daw.tp1.modelo.Paciente;
import br.tsi.daw.tp1.modelo.PedidoExame;

public class PedidoExameDAO {
	
	private Connection connection;
	
	public PedidoExameDAO() {
		this.connection = FabricaConexao.getConnection();
	}
	
	public void adicionaPedido(PedidoExame pedidoExame) {
	    String sql = "insert into pedido_exame (data_realizacao, recomendacao, exame_solicitado, hipotse_diagnostica, situacao, cpf_paciente, crm_medico, data_realizado, hora_realizacao, image_pdf) " +
	                 "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        // Convertendo Calendar para java.sql.Date
	        Date dataExame = new Date (pedidoExame.getDataExame().getTimeInMillis());
	        Date dataRealizada = new Date(pedidoExame.getDataRealizada().getTimeInMillis());

	        // Setando os parâmetros
	        stmt.setDate(1, new java.sql.Date(dataExame.getTime()));
	        stmt.setString(2, pedidoExame.getRecomendacoes());
	        stmt.setString(3, pedidoExame.getExameSolicitado());
	        stmt.setString(4, pedidoExame.getHipotseDiagnostica());
	        stmt.setString(5, pedidoExame.getSituacao());
	        stmt.setString(6, pedidoExame.getPaciente().getCpf());
	        stmt.setString(7, pedidoExame.getMedico().getCrm());
	        stmt.setDate(8,new java.sql.Date (dataRealizada.getTime()));
	        stmt.setTime(9, pedidoExame.getHoraRealizado());
	        stmt.setString(10, pedidoExame.getImagePdf());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean verificaPedido(String situacao, String cpfPaciente, String tipoExame) {
		String sql = "select * from pedido_exame where cpf_paciente=? and exame_solicitado=?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1,cpfPaciente);
			stmt.setString(2, situacao);
			stmt.setString(2, tipoExame);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public PedidoExame obterPedidoExamePorId(int id) {
		String sql = "select * from pedido_exame where id=?";
		PedidoExame pedidoExame = null;
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				pedidoExame = new PedidoExame();
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_realizacao"));
				pedidoExame.setDataExame(data);
				pedidoExame.setExameSolicitado(rs.getString("exame_solicitado"));
				pedidoExame.setHipotseDiagnostica(rs.getString("hipotse_diagnostica"));
				pedidoExame.setId(rs.getInt("id"));
				Medico medico = new Medico();
				MedicoDAO medicoDAO = new MedicoDAO();
				medico = medicoDAO.recuperaMedico(rs.getString("crm_medico"));
				pedidoExame.setMedico(medico);
				Paciente paciente = new Paciente();
				paciente.setCpf(rs.getString("cpf_paciente"));
				PacienteDAO pacienteDAO = new PacienteDAO();
				paciente = pacienteDAO.recuperaPaciente(paciente);
				pedidoExame.setPaciente(paciente);
				pedidoExame.setRecomendacoes(rs.getString("recomendacao"));
				pedidoExame.setSituacao(rs.getString("situacao"));
				Calendar data2 = Calendar.getInstance();
				data2.setTime(rs.getDate("data_realizado"));
				pedidoExame.setDataRealizada(data2);
				pedidoExame.setImagePdf(rs.getString("image_pdf"));
				pedidoExame.setHoraRealizado(rs.getTime("hora_realizacao"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return pedidoExame;
	}
	
	public List<PedidoExame> pedidosDoDia() {
		List<PedidoExame> exames = new ArrayList<PedidoExame>();
		String sql = "select * from pedido_exame";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			//Pegando a data atual para verificação
			String dataAtual = "2023-10-19";
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_realizacao"));
				if(dataAtual.equals(converteCalendarEmString(data)) && rs.getString("situacao").equals("Aguardando Exame")) {
					PedidoExame pedidoExame = new PedidoExame();
					pedidoExame.setDataExame(data);
					pedidoExame.setExameSolicitado(rs.getString("exame_solicitado"));
					pedidoExame.setHipotseDiagnostica(rs.getString("hipotse_diagnostica"));
					pedidoExame.setId(rs.getInt("id"));
					Medico medico = new Medico();
					medico.setCrm(rs.getString("crm_medico"));
					pedidoExame.setMedico(medico);
					Paciente paciente = new Paciente();
					paciente.setCpf(rs.getString("cpf_paciente"));
					pedidoExame.setPaciente(paciente);
					pedidoExame.setRecomendacoes(rs.getString("recomendacao"));
					pedidoExame.setSituacao(rs.getString("situacao"));
					exames.add(pedidoExame);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return exames;
	}
	
	public List<PedidoExame> examesDoDia() {
		List<PedidoExame> exames = new ArrayList<PedidoExame>();
		String sql = "select * from pedido_exame";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			//Pegando a data atual para verificação
			String dataAtual = "2023-10-16";
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_realizado"));
				if(dataAtual.equals(converteCalendarEmString(data)) && rs.getString("situacao").equals("Aguardando Laudo")) {
					PedidoExame pedidoExame = new PedidoExame();
					pedidoExame.setDataExame(data);
					pedidoExame.setExameSolicitado(rs.getString("exame_solicitado"));
					pedidoExame.setHipotseDiagnostica(rs.getString("hipotse_diagnostica"));
					pedidoExame.setId(rs.getInt("id"));
					Medico medico = new Medico();
					medico.setCrm(rs.getString("crm_medico"));
					pedidoExame.setMedico(medico);
					Paciente paciente = new Paciente();
					paciente.setCpf(rs.getString("cpf_paciente"));
					pedidoExame.setPaciente(paciente);
					pedidoExame.setRecomendacoes(rs.getString("recomendacao"));
					pedidoExame.setSituacao(rs.getString("situacao"));
					exames.add(pedidoExame);
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return exames;
	}
	
	public String obtemDataAtual() {
		// Obtenha a data atual
        Date dataAtual = new Date();
        // Formate a data no formato desejado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataAtual);
	}
	
	private String converteCalendarEmString(Calendar calendar) {
		// Converta o Calendar para Date
        Date data = calendar.getTime();

        // Formate a data no formato desejado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(data);
	}
	
	public static Time getCurrentTimeForPostgres() {
        // Get the current time as a java.util.Date object
        Date currentTime = new Date();

        // Format the time in "HH:mm:ss" format
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = sdf.format(currentTime);

        // Create a java.sql.Time object from the formatted time
        return Time.valueOf(formattedTime);
    }
	
	 public static Date getCurrentDateFormatted() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = sdf.format(new Date());

	        try {
	            return sdf.parse(formattedDate);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	public void adicionaPdfNoPedido(String pdfBytes, int id) {
	    String sql = "update pedido_exame set image_pdf=?,situacao=?, data_realizado=?, hora_realizacao=? where id=?";

	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	    	Time horaRealizacao = getCurrentTimeForPostgres();
	    	
	        stmt.setString(1, pdfBytes);
	        stmt.setString(2,"Aguardando Laudo");
	        stmt.setDate(3, new java.sql.Date(getCurrentDateFormatted().getTime()));
	        stmt.setTime(4, horaRealizacao);
	        stmt.setInt(5, id);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void mudaSituacaoDoExame(String novaSituacao, int id) {
		String sql = "update pedido_exame set situacao=? where id=?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, novaSituacao);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verificaExamesCancelados() {
		String sql = "select * from pedido_exame"; 
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			String dataAtual = obtemDataAtual();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Date dataRealizacao = rs.getDate("data_realizacao");
		        Calendar calendarData = Calendar.getInstance();
		        calendarData.setTime(dataRealizacao);

		        // Converta a data atual para um objeto Date
		        Date dataAtualDate = sdf.parse(dataAtual);

		        // Compare as datas, e se a data prevista pra realização de exames for menor que a data atual o exame é cancelado
		        if (calendarData.getTime().before(dataAtualDate) && !rs.getString("situacao").equals("Exame cancelado")) {
		            EnviaEmail enviaEmail = new EnviaEmail();
		            enviaEmail.enviarEmail("lkarendeoliveirasilva@gmail.com", "Cancelamento do Exame",enviaEmail.montagemCancelamentoEmail(obterPedidoExamePorId(rs.getInt("id"))));
		            mudaSituacaoDoExame("Exame cancelado", rs.getInt("id"));
		        }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

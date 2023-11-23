package br.tsi.daw.tp1.modelo;

import java.sql.Time;
import java.util.Calendar;

public class PedidoExame {
	private String exameSolicitado,recomendacoes,situacao,hipotseDiagnostica,imagePdf;
	private Medico medico;
	private Paciente paciente;
	private Calendar dataExame,dataRealizada;
	private int id;
    private Time horaRealizado;
    
	public String getExameSolicitado() {
		return exameSolicitado;
	}
	
	public void setExameSolicitado(String exameSolicitado) {
		this.exameSolicitado = exameSolicitado;
	}
	
	public String getRecomendacoes() {
		return recomendacoes;
	}
	
	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getHipotseDiagnostica() {
		return hipotseDiagnostica;
	}
	
	public void setHipotseDiagnostica(String hipotseDiagnostica) {
		this.hipotseDiagnostica = hipotseDiagnostica;
	}
	
	public Medico getMedico() {
		return medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Calendar getDataExame() {
		return dataExame;
	}
	
	public void setDataExame(Calendar dataExame) {
		this.dataExame = dataExame;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getImagePdf() {
		return imagePdf;
	}

	public void setImagePdf(String imagePdf) {
		this.imagePdf = imagePdf;
	}

	public Calendar getDataRealizada() {
		return dataRealizada;
	}

	public void setDataRealizada(Calendar dataRealizada) {
		this.dataRealizada = dataRealizada;
	}

	public Time getHoraRealizado() {
		return horaRealizado;
	}

	public void setHoraRealizado(Time horaRealizado) {
		this.horaRealizado = horaRealizado;
	}
	
	
}

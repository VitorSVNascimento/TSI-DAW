package vsvn.tsi.daw.cardio.modelo;

import java.util.Calendar;

import vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas;
import vsvn.tsi.daw.cardio.enums.SituacaoExame;
import vsvn.tsi.daw.cardio.enums.TiposDeExames;

public class Exame {

	private Long id;
	private Calendar datapedido;
	private TiposDeExames tipo;
	private Calendar data_e_hora_realizacao;
	private HipotesesDiagnosticas hipotese;
	private String crm;
	private String cpf;
	private SituacaoExame situacao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDatapedido() {
		return datapedido;
	}
	public void setDatapedido(Calendar datapedido) {
		this.datapedido = datapedido;
	}
	public TiposDeExames getTipo() {
		return tipo;
	}
	public void setTipo(TiposDeExames tipo) {
		this.tipo = tipo;
	}
	public Calendar getData_e_hora_realizacao() {
		return data_e_hora_realizacao;
	}
	public void setData_e_hora_realizacao(Calendar data_e_hora_realizacao) {
		this.data_e_hora_realizacao = data_e_hora_realizacao;
	}
	public HipotesesDiagnosticas getHipotese() {
		return hipotese;
	}
	public void setHipotese(HipotesesDiagnosticas hipotese) {
		this.hipotese = hipotese;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public SituacaoExame getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoExame situacao) {
		this.situacao = situacao;
	}
	
	
	
}

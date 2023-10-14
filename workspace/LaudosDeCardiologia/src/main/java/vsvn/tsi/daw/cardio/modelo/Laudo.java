package vsvn.tsi.daw.cardio.modelo;

import vsvn.tsi.daw.cardio.enums.HipotesesDiagnosticas;
import vsvn.tsi.daw.cardio.enums.SituacaoLaudo;

public class Laudo {
	
	private Long id;
	private Exame exame;
	private SituacaoLaudo situacao;
	private HipotesesDiagnosticas conclusao;
	private String descricao,images_path,crm;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Exame getExame() {
		return exame;
	}
	public void setExame(Exame exame) {
		this.exame = exame;
	}
	public SituacaoLaudo getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoLaudo situacao) {
		this.situacao = situacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public HipotesesDiagnosticas getConclusao() {
		return conclusao;
	}
	public void setConclusao(HipotesesDiagnosticas conclusao) {
		this.conclusao = conclusao;
	}
	public String getImages_path() {
		return images_path;
	}
	public void setImages_path(String images_path) {
		this.images_path = images_path;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}

}

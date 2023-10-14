package vsvn.tsi.daw.cardio.modelo;

import vsvn.tsi.daw.cardio.enums.SituacaoLaudo;

public class Laudo {
	
	private Long id,id_exame;
	private SituacaoLaudo situacao;
	private String descricao,conclusao,images_path,crm;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_exame() {
		return id_exame;
	}
	public void setId_exame(Long id_exame) {
		this.id_exame = id_exame;
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
	public String getConclusao() {
		return conclusao;
	}
	public void setConclusao(String conclusao) {
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

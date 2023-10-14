package vsvn.tsi.daw.cardio.enums;

public enum SituacaoLaudo {
	PROVISORIO("Provisório"),
	DEFINITIVO("Definitivo");
	
	private String situacao;
	
	SituacaoLaudo(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public static SituacaoLaudo getSituacaoLaudoFromString(String situacao) {
	    for (SituacaoLaudo laudo : SituacaoLaudo.values()) 
	        if (laudo.situacao.equalsIgnoreCase(situacao)) 
	            return laudo;
	        
	    throw new IllegalArgumentException("Situação de exame não encontrada para a descrição: " + situacao);
	}

}

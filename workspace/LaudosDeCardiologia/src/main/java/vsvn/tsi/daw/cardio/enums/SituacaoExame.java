package vsvn.tsi.daw.cardio.enums;

public enum SituacaoExame {

	AGUARDANDO_EXAME("Aguardando Exame"),
	AGUARDANDO_LAUDO("Aguardando Laudo"),
	LAUDO_REALIZADO("Laudo Realizado");
	
	private String descricao;
	
	SituacaoExame(String descricao) {
		this.descricao = descricao;
	}
	
	public static SituacaoExame getSituacaoExameFromString(String descricao) {
	    for (SituacaoExame situacao : SituacaoExame.values()) 
	        if (situacao.descricao.equalsIgnoreCase(descricao)) 
	            return situacao;
	        
	    throw new IllegalArgumentException("Situação de exame não encontrada para a descrição: " + descricao);
	}
	
	
	
}

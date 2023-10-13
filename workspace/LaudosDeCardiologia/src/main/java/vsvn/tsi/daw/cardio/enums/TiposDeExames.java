package vsvn.tsi.daw.cardio.enums;




public enum TiposDeExames {
	ELETROCARDIOGRAMA("Eletrocardiograma",
			"NA VÉSPERA DO EXAME\n Homens: Aparar os pelos do peito um dia antes do exame.\n\n NO DIA DO EXAME\nChegar 10 minutos antes do horário agendado;\nTrazer o pedido médico e documento de identidade\nMenores de 18 anos deverão estar acompanhados por um responsável\nMulheres: Usar top esportivo ou sutiã sem “arame”."),
	ECOCARDIOGRAMA("Ecocardiograma","Em crianças pequenas, pode ser necessário sedação, o que requer jejum de 4 a 6 horas.");
	
	private final String descricao,recomendacoes;
	
	 TiposDeExames(String descricao, String recomendacoes) {
		this.descricao = descricao;
		this.recomendacoes = recomendacoes;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	 
	public String getRecomendacoes() {
		return recomendacoes;
	}

	public static TiposDeExames getTipoDeExameFromDescricao(String descricao) {
	    for (TiposDeExames tipo : TiposDeExames.values()) {
	        if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
	            return tipo;
	        }
	    }
	    throw new IllegalArgumentException("Tipo de exame não encontrado para a descrição: " + descricao);
	}

}

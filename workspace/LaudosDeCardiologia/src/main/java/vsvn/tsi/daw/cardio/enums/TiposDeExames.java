package vsvn.tsi.daw.cardio.enums;

public enum TiposDeExames {
	ELETROCARDIOGRAMA("Eletrocardiograma"),
	ECOCARDIOGRAMA("Ecocardiograma");
	
	private final String descricao;
	
	 TiposDeExames(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
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

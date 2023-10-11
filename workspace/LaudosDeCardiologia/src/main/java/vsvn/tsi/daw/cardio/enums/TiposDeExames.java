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
	 
	

}

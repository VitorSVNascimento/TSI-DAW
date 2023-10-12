package vsvn.tsi.daw.cardio.enums;

public enum HipotesesDiagnosticas {
	
	   PARADA_CARDIACA("I46", "Parada cardíaca"),
	    TAQUICARDIA_PAROXISTICA("I47", "Taquicardia paroxística"),
	    FLUTTER_E_FIBRILACAO_ARTERIAL("I48", "Flutter e fibrilação atrial"),
	    OUTRAS_ARRITIMIAS_CARDIACAS("I49", "Outras arritmias cardíacas"),
	    CARDIOMIOPATIAS("I42", "Cardiomiopatias");

	    private String codigo;
	    private String descricao;

	    HipotesesDiagnosticas(String codigo, String descricao) {
	        this.codigo = codigo;
	        this.descricao = descricao;
	    }

	    public String getCodigo() {
	        return codigo;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public static String getCodigoFromString(String codigoDescricao) {
	        return codigoDescricao.split(" - ")[0];
	    }

	    public static String getDescricaoFromString(String codigoDescricao) {
	        return codigoDescricao.split(" - ")[1];
	    }
	    
	    public static HipotesesDiagnosticas fromString(String str) {
	        for (HipotesesDiagnosticas value : HipotesesDiagnosticas.values()) {
	            if (value.toString().equals(str)) {
	                return value;
	            }
	        }
	        return null;
	    }
	    public static HipotesesDiagnosticas fromCodigo(String str) {
	    	for (HipotesesDiagnosticas value : HipotesesDiagnosticas.values()) {
	    		if (value.getCodigo().equals(str)) {
	    			return value;
	    		}
	    	}
	    	return null;
	    }


	    public String toString() {
	        return codigo + " - " + descricao;
	    }
	    
	    

}

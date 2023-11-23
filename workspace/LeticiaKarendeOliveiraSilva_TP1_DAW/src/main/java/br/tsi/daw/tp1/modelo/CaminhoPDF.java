package br.tsi.daw.tp1.modelo;

public class CaminhoPDF {
	public String extrairCaminhoRelativo(String caminhoCompleto, String tipoExame) {
	    String caminhoPasta = "";

	    if (tipoExame.equals("ecocardiograma")) {
	        caminhoPasta = "ecocardiogramaPDF\\";
	    } else if (tipoExame.equals("eletrocardiograma")) {
	        caminhoPasta = "eletrocardiogramaPDF\\";
	    }

	    int index = caminhoCompleto.lastIndexOf(caminhoPasta);
	    if (index == -1) {
	        return "";  // Tipo de exame inválido ou caminho não contém a pasta específica
	    }

	    String caminhoRelativo = caminhoCompleto.substring(index);
	    System.out.println(caminhoRelativo);
	    return caminhoRelativo;
	}


}

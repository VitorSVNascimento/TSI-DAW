package vsvn.tsi.daw.cardio.enums;

public enum CategoriaMedico {
    MEDICO("Médico"),
    MEDICO_DOCENTE("Médico Docente"),
    MEDICO_RESIDENTE("Médico Residente");

    private final String descricao;

    CategoriaMedico(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static CategoriaMedico fromDescricao(String descricao) {
        for (CategoriaMedico categoria : CategoriaMedico.values()) {
            if (categoria.descricao.equalsIgnoreCase(descricao)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }

}

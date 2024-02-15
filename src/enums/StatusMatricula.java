package enums;

public enum StatusMatricula {

    ATIVO("Ativo", "Calouro"),
    TRANCADO("Trancado", "Preguiçoso"),
    FORMADO("Formado", "Guerreiro");

    private final String situacao;
    private final String descricao;

    StatusMatricula(String situacao, String descricao) {
        this.situacao = situacao;
        this.descricao = descricao;
    }

    public String getSituacao(){
        return situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusMatricula getDescricaoPelaSituacao(String situacao){
        for (StatusMatricula value : values()) {
            if(value.situacao == situacao){
                return value;
            }
        }
        return null;
    }
}

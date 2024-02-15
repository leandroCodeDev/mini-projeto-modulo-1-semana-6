package enums;

public enum StatusMatricula {

    ATIVO("Ativo"),
    TRANCADO("Trancado"),
    FORMADO("Formado");

    private final String label;

    StatusMatricula(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}

package enums;

public enum CargoFuncionario {

    INICIANTE("Iniciante"),
    EXPERIENTE("Experiente"),
    AVANCADO("Avançado");

    private final String label;

    CargoFuncionario(String label) {
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

}

package streams;

public enum Resultado {
    APROVADO("Aprovado"),
    REPROVADO("Reprovado"),
    EXAME_FINAL("Exame Final");

    private String valor;

    Resultado(String valor) {
        this.valor = valor;
    }
}

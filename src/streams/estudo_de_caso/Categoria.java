package streams.estudo_de_caso;

public enum Categoria {

    LIMPEZA(1),
    CEREAIS(2),
    BEBIDAS(3);

    private int valor;

    Categoria(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }


}

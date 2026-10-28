package streams.estudo_de_caso;

public class Produto {

    private String descricao;
    private Double preco;
    private Categoria categoria;

    public Produto() {
    }

    public Produto(String descricao, Double preco, Categoria categoria) {
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return
                "descricao: " + descricao +
                ", preco: " + preco +
                ", categoria: " + categoria;
    }
}

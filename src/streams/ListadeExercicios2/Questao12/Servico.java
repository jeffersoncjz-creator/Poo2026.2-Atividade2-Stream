package streams.ListadeExercicios2.Questao12;

public class Servico {

    private TipoServico tipoServico;
    private double valor;

    public Servico(TipoServico tipoServico, double valor) {
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public double getValor() {
        return valor;
    }
}

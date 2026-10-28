package streams;

import java.util.List;
import java.util.Objects;

public class Disciplina {

    private DisciplinaEnum nome;
    private List<Double> notas;
    private Resultado resultado;
    private Double media;

    public Disciplina() {
    }

    public Disciplina(DisciplinaEnum nome, List<Double> notas, Resultado resultado, Double media) {
        this.nome = nome;
        this.notas = notas;
        this.resultado = resultado;
        this.media = media;
    }

    public DisciplinaEnum getNome() {
        return nome;
    }

    public void setNome(DisciplinaEnum nome) {
        this.nome = nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "\n    Disciplina: " + nome +
                "\n    Notas: " + notas +
                "\n    Resultado: " + resultado +
                "\n    Média: " + String.format("%.2f", media) +
                "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return nome == that.nome;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}

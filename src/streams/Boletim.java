package streams;

import java.util.List;

public class Boletim {
    private Pessoa pessoa;
    private List<Disciplina> disciplinas;


    public Boletim() {
    }

    public Boletim(Pessoa pessoa, List<Disciplina> disciplinas) {
        this.pessoa = pessoa;
        this.disciplinas = disciplinas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Resultado resultado(Disciplina disciplina){
        Resultado r = switch (calcularMedia(disciplina)){
            case Double m when m >= 7.0 -> Resultado.APROVADO;
            case Double m when m >= 4.0 -> Resultado.EXAME_FINAL;
            case Double m -> Resultado.REPROVADO;
        };
        disciplina.setResultado(r);
        return r;

    }

    public Double calcularMedia(Disciplina disciplina){
        List<Double> notas = disciplina.getNotas();

        double soma = notas.stream().mapToDouble(Double::doubleValue).sum();

        double media = notas.isEmpty() ? 0.0 : soma / notas.size();

        disciplina.setMedia(media);
        return media;
    }

    public void calcularResultados(){
        disciplinas.forEach(this::resultado);
    }

    @Override
    public String toString() {
        return "\n====================================" +
                "\n" + pessoa +
                "\nDisciplinas:" + disciplinas +
                "\n====================================";
    }
}

package streams.ListadeExercicios2.Questao12;
import java.util.ArrayList;
import java.util.List;

public class Autonomo {

    private String nome;
    private String cpf;
    private List<Servico> servicos;

    public Autonomo(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.servicos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }
}
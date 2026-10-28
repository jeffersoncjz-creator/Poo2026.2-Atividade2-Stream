package optional;

public class Pessoa {

    private String nome;
    private int idade;
    private Genero genero;
    private String email;


    public Pessoa() {
    }

    public Pessoa(String nome, int idade, Genero genero, String email) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", genero=" + genero +
                ", email='" + email + '\'' +
                '}';
    }
}

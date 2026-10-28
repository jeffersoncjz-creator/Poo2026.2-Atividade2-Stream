package streams;
import optional.Genero;
import java.util.List;

public class App {

    static void main() {
//        var pessoa = getPessoas(); // ler primeiro, depois tipar... atribiu o tipo por inferencia
        List<Pessoa> pessoas = getPessoas(); // retorna uma lista de pessoa
//        pessoas.forEach( p -> System.out.println(p)); //expressao lambda
//        pessoas.forEach(System.out::println); //referencia ao metodo

        List<Pessoa> generoFeminino = pessoas.stream().filter(p -> p.getGenero().equals(Genero.FEMININO)).toList();
        generoFeminino.forEach(System.out::println);

        System.out.println("------- Genero Feminino Apenas Nomes -------");

        List<String> generoFemininoApenasNome = pessoas.stream().filter(p -> p.getGenero().equals(Genero.FEMININO) && p.getIdade() > 18).map(Pessoa::getNome).toList();
        generoFemininoApenasNome.forEach(System.out::println);

    }

    public static List<Pessoa> getPessoas(){
        return List.of(
                new Pessoa("Jose", 20, Genero.MASCULINO, "jose@gmail.com"),
                new Pessoa("Maria", 52, Genero.FEMININO, "maria@gmail.com"),
                new Pessoa("Lara", 16, Genero.FEMININO, "lara@gmail.com"),
                new Pessoa("Luiz", 17, Genero.MASCULINO, "luiz@gmail.com"),
                new Pessoa("Roberta", 35, Genero.FEMININO, "roberta@gmail.com"));
    }
}

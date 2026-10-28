package streams.ListadeExercicios2;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class Questoes {

    public static void main(String[] args) {
//        exemplo01();
//        exemplo02();
//        exemplo03();
//        exemplo04();
//        exemplo05();
//        exemplo06();
//        exemplo07();
//        exemplo08();
//        exemplo09();
//        exemplo10();
//        exemplo11();
    }

    // Questão 1 - Filtrar apenas os numeros pares
    static void exemplo01() {
        List<Integer> numeros = List.of(4, 25, 32, 78, 45, 13, 10, 77, 58, 61, 52);

        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println("Numeros pares: " + pares);
    }

    // Questão 2 - Converter nomes para maiusculas
    static void exemplo02() {
        List<String> nomes = List.of("Ana", "Pedro", "Maria", "Carlos");

        List<String> resultado = nomes.stream()
                .map(n -> n.toUpperCase())
                .toList();

        System.out.println("Nomes: " + resultado);
    }

    // Questão 3 - Multiplicar cada elemento por 2
    static void exemplo03() {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        numeros.stream()
                .forEach(n -> System.out.println(n * 2));
    }

    // Questão 4 - Contar numeros maiores que 10
    static void exemplo04() {
        List<Integer> numeros = List.of(4, 25, 32, 5, 45, 13, 8, 77, 58, 2, 52);

        long quantidade = numeros.stream()
                .filter(n -> n > 10)
                .count();

        System.out.println("Maiores que 10: " + quantidade);
    }

    // Questão 5 - Filtrar nomes com A e ordenar
    static void exemplo05() {
        List<String> nomes = List.of("Pedro", "Ana", "José", "Maria",
                "Antonia", "Augusto", "Carlos", "Francisco");

        List<String> resultado = nomes.stream()
                .filter(n -> n.startsWith("A"))
                .sorted()
                .toList();

        System.out.println("Nomes com A: " + resultado);
    }

    // Questão 6 - Encontrar o maior numero
    static void exemplo06() {
        List<Integer> numeros = List.of(5, 12, 44, 8, 27);

        int maior = numeros.stream()
                .mapToInt(n -> n)
                .max()
                .orElse(0);

        System.out.println("Maior numero: " + maior);
    }

    // Questão 7 - Contar palavras com mais de 5 letras
    static void exemplo07() {
        List<String> palavras = List.of("casa", "computador",
                "livro", "cadeira", "sol", "abacaxi");

        long quantidade = palavras.stream()
                .filter(p -> p.length() > 5)
                .count();

        System.out.println("Quantidade: " + quantidade);
    }

    // Questão 8 - Filtrar pessoas com mais de 18 anos
    static void exemplo08() {
        List<Pessoa> pessoas = List.of(
                new Pessoa("Ana", 20),
                new Pessoa("Pedro", 17),
                new Pessoa("Maria", 32),
                new Pessoa("Jose", 18)
        );

        List<String> nomes = pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .map(p -> p.getNome())
                .toList();

        System.out.println("Pessoas: " + nomes);
    }

    // Questão 9 - Verificar se todos sao positivos
    static void exemplo09() {
        List<Integer> numeros = List.of(2, 4, 6, 8);

        boolean positivos = numeros.stream()
                .allMatch(n -> n > 0);

        System.out.println("Todos positivos: " + positivos);
    }

    // Questão 10 - Somar valores dos pedidos
    static void exemplo10() {
        List<Pedido> pedidos = List.of(
                new Pedido(1, 120.50),
                new Pedido(2, 49.90),
                new Pedido(3, 29.60)
        );

        double total = pedidos.stream()
                .mapToDouble(p -> p.getValor())
                .sum();

        System.out.println("Valor total: " + total);
    }

    // Questão 11 - Agrupar palavras por tamanho
    static void exemplo11() {
        List<String> palavras = List.of("sol", "casa",
                "lua", "mesa", "livro", "bola");

        Map<Integer, List<String>> grupos = palavras.stream()
                .collect(Collectors.groupingBy(p -> p.length()));

        System.out.println("Palavras agrupadas: " + grupos);
    }
}
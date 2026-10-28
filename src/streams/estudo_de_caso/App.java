package streams.estudo_de_caso;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    static void main() {

        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        String menu = """
                Digite uma categoria:
                1 - Limpeza
                2 - Cereais
                3 - Bebidas
                0 - Sair
                """;

        while (opcao != 0){try {if (opcao == 0) {System.exit(0);}
            System.out.println(menu);
            int categoria = sc.nextInt();
            Produto maisCaroPorCategoria = carrinho()
                    .stream().filter(p -> p.getCategoria().getValor() == categoria)
                    .max(Comparator.comparingDouble(Produto::getPreco))
                    .orElseThrow(() -> new InputMismatchException("Categoria inválida"));
//                .orElse(null);

            System.out.println(maisCaroPorCategoria);
        }catch (InputMismatchException e) {
            sc.next();
            System.out.println(e.getMessage());
        }

        }






    }

    static List<Produto> carrinho(){
        return List.of(
                new Produto("Refrigerante", 13.0, Categoria.BEBIDAS),
                new Produto("Café", 28.0, Categoria.CEREAIS),
                new Produto("Açucar", 5.0, Categoria.CEREAIS),
                new Produto("Sabonete", 25.0, Categoria.LIMPEZA),
                new Produto("Detergente", 8.0, Categoria.LIMPEZA),
                new Produto("Água", 13.0, Categoria.BEBIDAS)
        );
    }


}

package streams.ListadeExercicios2.Questao12;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CadastroAutonomos {

    static Scanner sc = new Scanner(System.in);
    static List<Autonomo> autonomos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar autonomo");
            System.out.println("2 - Cadastrar servico");
            System.out.println("3 - Consultar servicos por CPF");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarAutonomo();
                    break;

                case 2:
                    cadastrarServico();
                    break;

                case 3:
                    consultarServicos();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    static void cadastrarAutonomo() {

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        Autonomo existente = buscarAutonomo(cpf);

        if (existente != null) {
            System.out.println("CPF ja cadastrado!");
            return;
        }

        Autonomo autonomo = new Autonomo(nome, cpf);
        autonomos.add(autonomo);

        System.out.println("Autonomo cadastrado!");
    }

    static Autonomo buscarAutonomo(String cpf) {

        return autonomos.stream()
                .filter(a -> a.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    static void cadastrarServico() {

        System.out.print("CPF do autonomo: ");
        String cpf = sc.nextLine();

        Autonomo autonomo = buscarAutonomo(cpf);

        if (autonomo == null) {
            System.out.println("Autonomo nao encontrado!");
            return;
        }

        System.out.println("1 - ELETRICO");
        System.out.println("2 - HIDRAULICO");
        System.out.println("3 - ALVENARIA");

        System.out.print("Tipo de servico: ");
        int opcao = Integer.parseInt(sc.nextLine());

        TipoServico tipo;

        switch (opcao) {
            case 1:
                tipo = TipoServico.ELETRICO;
                break;

            case 2:
                tipo = TipoServico.HIDRAULICO;
                break;

            case 3:
                tipo = TipoServico.ALVENARIA;
                break;

            default:
                System.out.println("Tipo invalido!");
                return;
        }

        System.out.print("Valor do servico: ");
        double valor = Double.parseDouble(
                sc.nextLine().replace(",", ".")
        );

        Servico servico = new Servico(tipo, valor);

        autonomo.adicionarServico(servico);

        System.out.println("Servico cadastrado!");
    }

    static void consultarServicos() {

        System.out.print("Digite o CPF: ");
        String cpf = sc.nextLine();

        Autonomo autonomo = buscarAutonomo(cpf);

        if (autonomo == null) {
            System.out.println("Autonomo nao encontrado!");
            return;
        }

        System.out.println("Nome: " + autonomo.getNome());
        System.out.println("CPF: " + autonomo.getCpf());

        Map<TipoServico, List<Servico>> grupos =
                autonomo.getServicos().stream()
                        .collect(Collectors.groupingBy(
                                s -> s.getTipoServico()
                        ));

        grupos.forEach((tipo, lista) -> {

            System.out.println("\nTipo: " + tipo);

            lista.forEach(s ->
                    System.out.printf(
                            "Valor: R$ %.2f%n", s.getValor()
                    )
            );

            double subtotal = lista.stream()
                    .mapToDouble(s -> s.getValor())
                    .sum();

            System.out.printf(
                    "Subtotal: R$ %.2f%n", subtotal
            );
        });

        double total = autonomo.getServicos().stream()
                .mapToDouble(s -> s.getValor())
                .sum();

        System.out.printf(
                "\nTotal geral: R$ %.2f%n", total
        );
    }
}
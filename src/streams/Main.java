package streams;

import optional.Genero;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static void main() {
        List<Boletim> boletims = getBoletins();
        boletims.forEach(Boletim::calcularResultados);

        List<Boletim> aprovados = boletims.stream().filter(b -> b.getDisciplinas().stream().allMatch(d -> d.getResultado().equals(Resultado.APROVADO))).toList();


//        System.out.println(aprovados);

//        boletims.forEach(b -> {
//            b.getDisciplinas().forEach(d -> System.out.println(d.getNome()));
//        });

        Set<Disciplina> comFlatMap = boletims.stream().flatMap(b -> b.getDisciplinas().stream()).collect(Collectors.toSet());

//        System.out.println("-------------------------------------------------");
//        comFlatMap.forEach(d -> System.out.println(d.getNome()));

        Map<Pessoa, List<Boletim>> agrupadoPorAluno = boletims.stream().collect(Collectors.groupingBy(Boletim::getPessoa));

        agrupadoPorAluno.forEach((pessoa, bol) -> {
            System.out.println("Aluno: " +pessoa.getNome());
            bol.forEach(b -> System.out.println(b.getDisciplinas()));
            System.out.println();
        });


    }

    public static List<Boletim> getBoletins(){
        Pessoa ana = new Pessoa("Ana", 25, Genero.FEMININO, "ana@email.com");
        Pessoa pedro = new Pessoa("Pedro", 15, Genero.MASCULINO, "pedro@email.com");
        Pessoa maria = new Pessoa("Maria", 40, Genero.FEMININO, "maria@email.com");
        Pessoa fernanda = new Pessoa("Fernanda", 16, Genero.FEMININO, "fernanda@email.com");
        Pessoa antonio = new Pessoa("Antonio", 38, Genero.MASCULINO, "antonio@email.com");
        Pessoa joao = new Pessoa("Joao", 49, Genero.MASCULINO, "joao@email.com");

        Boletim boletimAna = new Boletim(ana, List.of(new Disciplina(DisciplinaEnum.ALGORITMOS, List.of(9.5, 8.5, 9.5),null, 0.0),
                new Disciplina(DisciplinaEnum.BANCO_DE_DADOS, List.of(7.0, 7.5, 7.0),null, 0.0)));
        Boletim boletimPedro = new Boletim(pedro, List.of(new Disciplina(DisciplinaEnum.CALCULO_I, List.of(9.5, 9.5, 4.5),null, 0.0),
                new Disciplina(DisciplinaEnum.POO, List.of(7.0, 7.5, 8.0),null, 0.0)));
        Boletim boletimMaria = new Boletim(maria, List.of(new Disciplina(DisciplinaEnum.POO, List.of(9.5, 9.5, 4.5),null, 0.0),
                new Disciplina(DisciplinaEnum.CALCULO_I, List.of(9.0, 9.5, 9.0),null, 0.0)));


        List<Boletim> boletim = new ArrayList<>(List.of(boletimAna, boletimPedro, boletimMaria));
        return boletim;
    }

    static double mediaGeral(Boletim boletim){
        return boletim.getDisciplinas().stream().flatMap(d -> d.getNotas().stream()).mapToDouble(Double::doubleValue).average().orElse(0.0);
    }


}

package streams.exemplos.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamBasico {
    static void main (){
//        exemplo01();
//        exemplo02();
//        exemplo03();
        exemplo04();
    }
    static void exemplo01(){
        List<Integer> numeros = List.of(1,2,3,4,5,6);

        List<Integer> resultado = new ArrayList<>();

        for(Integer n : numeros){
            if(n % 2 == 0){
                resultado.add(n * 10);
            }
        }
        System.out.println("For each " +resultado);

        List<Integer> resultadoStream = numeros.stream().filter(n -> n % 2 == 0)
                .map(n -> n * 10).toList();
        System.out.println("Com stream: " +resultadoStream);
    }


    static void exemplo02() {

        List<Double> precos = List.of(10.5, 22.5, 100.9);

        List<Double> comAumentoDeDezPorCento = precos.stream().map(p -> p * 1.10).toList();

//        System.out.println(comAumentoDeDezPorCento);
        comAumentoDeDezPorCento.forEach(p -> System.out.printf("%.2f%n", p));
    }

    static void exemplo03() {
        List<Integer> idades = List.of(15,40,28,10,88,14);

        long maiorDeIdades = idades.stream().filter(i -> i >= 18).count();
        long menorDeIdades = idades.stream().filter(i -> i < 18).count();

        System.out.println("Maiores de Idade: " +maiorDeIdades);
        System.out.println("Menores de Idade: " +menorDeIdades);
    }

    static void exemplo04() {
        List<Integer> notas = List.of(7, 9, 6, 8);
        double media = notas.stream().mapToInt(n -> n).average().orElse(0);
        int menor = notas.stream().mapToInt(n -> n).min().orElse(0);
        int maior = notas.stream().mapToInt(n -> n).max().orElse(0);


        System.out.println("Media nota: " +media);
        System.out.println("Menor nota: " +menor);
        System.out.println("Maior nota: " +maior);
        }
    }

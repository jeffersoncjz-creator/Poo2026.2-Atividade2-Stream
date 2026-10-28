package optional;

import java.util.Optional;

public class App {

    static void main() {

        Pessoa ana = new Pessoa("Ana", 20, Genero.FEMININO, null);

//        Optional<String> valorQueExiste = Optional.of(ana.getNome());
//
//        Optional<String> podeSerNuloOuNao = Optional.ofNullable(ana.getEmail());
//
//        Optional<String> vazio = Optional.empty();

//        System.out.println(valorQueExiste);
//        System.out.println(podeSerNuloOuNao);
//        System.out.println(vazio);



//        Optional.of(ana.getEmail()); //no Optional.of o valor é obrigatorio, não pode ser nulo.

        String email = ana.getEmail();
        String contato;

//        if(email != null){
//            contato = email;
//        }else{
//            contato = "Usuario não possui email";
//        }

//        Optional.ofNullable(email).ifPresentOrElse(e -> System.out.println("Email enviado para" +e),() -> System.out.println(ana.getNome() +" não possui email"));

//                .orElse("Ana não possui email");

//        System.out.println(contato);

//        if(email == null){
//            throw new IllegalArgumentException("Email não localizado com if - else");
//        }
//        Optional.ofNullable(email).orElseThrow(() -> new IllegalArgumentException("Email nao localizado com Optional"));

        try{
            System.out.println(validaEmail(email));
        }catch (IllegalArgumentException e) {
            System.out.println("Erro " +e.getMessage());
        }


    }

    public static String validaEmail(String email){
        return Optional.ofNullable(email).orElseThrow(() ->
                new IllegalArgumentException("Email não localizado com Optional"));
    }


}

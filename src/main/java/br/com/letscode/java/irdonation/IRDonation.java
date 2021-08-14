package br.com.letscode.java.irdonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IRDonation {

    public static void main(String[] args) {
        SpringApplication.run(IRDonation.class, args);
    }

}
//TODO está aparecendo o mesmo que acontece no do Jessé. precisamos ver como resolver isso e como criar e
// autenticar um admin, se tiver alguma ideia e quiser fazer so dale

/* funções:
//TODO USUARIO
//TODO POST inserir usuario
//TODO GET listar todos
//TODO PUT alterar informações do usuário (se a gente considerar autenticação)
//TODO DELETE

CONTADOR
//TODO POST inserir contador
//TODO GET listar todos
//TODO PUT alterar informações do contador (se a gente considerar autenticação)
//TODO DELETE

CONTADOR/USUARIO -> ATENDIMENTO
//TODO GET listar usuário a ser atendido (fila)
//TODO DELETE

ONG
listar todos
//TODO POST inserir ONG's (somente admin)
//TODO PUT alterar informações das ongs
//TODO DELETE


 */



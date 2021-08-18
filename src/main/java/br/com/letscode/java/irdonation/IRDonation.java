package br.com.letscode.java.irdonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IRDonation {

    public static void main(String[] args) {
        SpringApplication.run(IRDonation.class, args);
    }

}

/* funções:
//TODO USUARIO
//TODO POST inserir usuario
//TODO GET listar todos contadores
//TODO PUT alterar informações do usuário (se a gente considerar autenticação)
//TODO DELETE

CONTADOR
//TODO POST inserir contador
//TODO GET listar todos usuários informados
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

//TODO padronizar controller -> "Service / repository"
 */



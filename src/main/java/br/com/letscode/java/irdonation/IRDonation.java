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
USUARIO
POST inserir usuario
GET listar todos
PUT alterar informações do usuário (se a gente considerar autenticação)

CONTADOR
POST inserir contador
GET listar todos
PUT alterar informações do contador (se a gente considerar autenticação)

CONTADOR/USUARIO -> ATENDIMENTO
GET listar usuário a ser atendido (fila)

ONG
GET listar todos
POST inserir ONG's (somente admin)


 */



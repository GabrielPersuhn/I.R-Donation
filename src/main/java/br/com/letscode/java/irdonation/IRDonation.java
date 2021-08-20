package br.com.letscode.java.irdonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class IRDonation {

    public static void main(String[] args) {
        SpringApplication.run(IRDonation.class, args);
    }

}

/*

//TODO segurança -> decidir

//TODO atendimento -> exclui do banco de dados Cliente (não deveria)

//TODO limpar todo o codigo

// TODO apresentação

 */



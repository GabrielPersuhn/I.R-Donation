package br.com.letscode.java.irdonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class IRDonation {

    public static void main(String[] args) {
        SpringApplication.run(IRDonation.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }

}

/*

//TODO segurança

//TODO verificar todo o codigo

 */



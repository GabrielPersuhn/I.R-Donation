package br.com.letscode.java.irdonation.contador;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ContadorResponse {

    private String nome;

    private String sobrenome;

    private String email;

    private Long telefone;

    public ContadorResponse(Contador contador) {
        this.nome = contador.getNome();
        this.sobrenome = contador.getSobrenome();
        this.email = contador.getEmail();
        this.telefone = contador.getTelefone();
    }

    public static List<ContadorResponse> convert(List<Contador> contadors){
        return contadors.stream().map(ContadorResponse::new).collect(Collectors.toList());
    }

}

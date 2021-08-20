package br.com.letscode.java.irdonation.cliente;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ClienteResponse {

    private String nome;

    private String sobrenome;

    private String email;

    private Long telefone;

    public ClienteResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }

    public static List<ClienteResponse> convert(List<Cliente> clientes) {
        return clientes.stream().map(ClienteResponse::new).collect(Collectors.toList());
    }

}

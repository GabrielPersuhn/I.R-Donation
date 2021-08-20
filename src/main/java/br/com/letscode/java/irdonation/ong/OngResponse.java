package br.com.letscode.java.irdonation.ong;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OngResponse {

    private String razaoSocial;


    private String email;

    private Long telefone;

    public OngResponse(Ong ong) {
        this.razaoSocial = ong.getRazaoSocial();
        this.email = ong.getEmail();
        this.telefone = ong.getTelefone();
    }

    public static List<OngResponse> convert(List<Ong> ongs) {
        return ongs.stream().map(OngResponse::new).collect(Collectors.toList());
    }

}

package br.com.letscode.java.irdonation.cliente;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity

@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column
    private Long cpf;

    @Column
    private String email;

    @Column
    private Long telefone;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private Boolean foiAtendido;
}

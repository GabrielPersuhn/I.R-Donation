package br.com.letscode.java.irdonation.usuario;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity

@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column
    @GeneratedValue
    private UUID id; //TODO registrar id em ordem crescente

    @Column
    private String cpf;

    @Column
    private String email;

    @Column
    private Long telefone;

    @Column
    private String nome;

    @Column
    private String sobrenome;
}

package br.com.letscode.java.irdonation.contador;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "contador")
public class Contador {

    @Id
    @Column
    @GeneratedValue
    private UUID id;

    @Column
    private String cpf;

    @Column
    private Long idCrc;

    @Column
    private String email;

    @Column
    private Long telefone;

    @Column
    private String nome;

    @Column
    private String sobrenome;
}



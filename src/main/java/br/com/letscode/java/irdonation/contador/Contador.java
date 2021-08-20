package br.com.letscode.java.irdonation.contador;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "contador")
public class Contador {

    @Id
    @Column
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column(unique = true)
    private Long cpf;

    @Column
    private Long idCrc;

    @Column
    private String email;

    @Column
    private Long telefone;


}


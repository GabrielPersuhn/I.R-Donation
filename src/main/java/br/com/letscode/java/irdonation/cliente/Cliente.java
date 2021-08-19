package br.com.letscode.java.irdonation.cliente;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter @Setter
@ToString
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private Long cpf;

    @Column
    private String email;

    @Column
    private Long telefone;

}

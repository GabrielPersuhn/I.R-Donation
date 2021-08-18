package br.com.letscode.java.irdonation.cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

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

    @JsonIgnore
    @Column
    private Boolean foiAtendido;
}

package br.com.letscode.java.irdonation.ong;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ong")
@Data
public class Ong {

    @Id
    @Column
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String razaoSocial;

    @Column
    private Long cnpj;

    @Column
    private String email;

    @Column
    private Long telefone;

}

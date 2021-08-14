package br.com.letscode.java.irdonation.ong;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ong")
@Data
public class Ong {

    @Id
    @Column
    private Long cnpj;

    @Column
    private String email;

    @Column
    private Long telefone;

    @Column
    private String razaoSocial;
}

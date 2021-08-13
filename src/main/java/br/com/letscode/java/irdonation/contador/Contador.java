package br.com.letscode.java.irdonation.contador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "contador")
public class Contador {
    @Id
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


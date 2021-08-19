package br.com.letscode.java.irdonation.contador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContadorRepository extends JpaRepository<Contador, Integer> {
    List<Contador> deleteContadorByCpf(Long cpf);
}

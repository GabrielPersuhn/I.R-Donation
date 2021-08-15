package br.com.letscode.java.irdonation.contador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContadorRepository extends JpaRepository<Contador, Long> {
}

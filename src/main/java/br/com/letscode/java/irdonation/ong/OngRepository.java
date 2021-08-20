package br.com.letscode.java.irdonation.ong;

import br.com.letscode.java.irdonation.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OngRepository extends JpaRepository<Ong, Integer> {
    Optional<Ong> findById(Integer id);
}

package br.com.letscode.java.irdonation.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findUsuarioByCpf(String cpf);

    List<Cliente> findUsuarioByCpfNotIn(List<String> IdLista);
}

package br.com.letscode.java.irdonation.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Cliente> findUsuarioByCpf(String cpf);

    List<Cliente> findUsuarioByCpfNotIn(List<String> IdLista);
}

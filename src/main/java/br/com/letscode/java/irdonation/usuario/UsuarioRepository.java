package br.com.letscode.java.irdonation.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findUsuarioById(String id);

    List<Usuario> findUsuarioByIdNotIn(List<String> IdLista);
}

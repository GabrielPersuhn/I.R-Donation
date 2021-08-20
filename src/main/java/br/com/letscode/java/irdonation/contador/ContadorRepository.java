package br.com.letscode.java.irdonation.contador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ContadorRepository extends JpaRepository<Contador, Integer> {
    Optional<Contador> findByCpf(Long cpf);

    @Modifying
    @Transactional
    @Query("delete from Contador where cpf = ?1")
    void deleteContadorByCpf(Long cpf);
}

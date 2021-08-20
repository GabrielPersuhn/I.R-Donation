package br.com.letscode.java.irdonation.ong;

import br.com.letscode.java.irdonation.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface OngRepository extends JpaRepository<Ong, Integer> {

    Optional<Ong> findByCnpj(Long cnpj);

    @Modifying
    @Transactional
    @Query("delete from Ong where cnpj = ?1")
    void deleteByCnpj(Long cnpj);
}

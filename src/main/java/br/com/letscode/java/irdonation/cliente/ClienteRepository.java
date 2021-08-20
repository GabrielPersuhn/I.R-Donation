package br.com.letscode.java.irdonation.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Cliente where id in (select min(id) from Cliente)")
    void deleteClienteByIdOrderByIdAsc();

    Optional<Cliente> findById(Integer id);

}


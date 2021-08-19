package br.com.letscode.java.irdonation.cliente;

import br.com.letscode.java.irdonation.contador.Contador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Modifying
    @Transactional
    @Query("delete from Cliente where id in (select min(id) from Cliente)")
    void deleteClienteByIdOrderByIdAsc();

    List<Contador> deleteClienteByCpf(Long cpf);

}


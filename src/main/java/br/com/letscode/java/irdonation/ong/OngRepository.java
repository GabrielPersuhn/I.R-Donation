package br.com.letscode.java.irdonation.ong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OngRepository extends JpaRepository<Ong, Integer> {
    List<Ong> deleteOngByCnpj(Long cpnj);
}

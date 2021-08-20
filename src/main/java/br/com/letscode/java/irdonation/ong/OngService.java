package br.com.letscode.java.irdonation.ong;

import br.com.letscode.java.irdonation.cliente.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OngService {

    private final OngRepository repository;

    public List<Ong> listAll() {
        return this.repository.findAll();
    }

    public void cadastrarOng(Ong ong) {
        this.repository.save(ong);
    }

    public void deleteByCnpj(Long cnpj) {
        this.repository.deleteByCnpj(cnpj);
    }

    public Optional<Ong> findByCnpj(Long cnpj) {
        return this.repository.findByCnpj(cnpj);
    }

}

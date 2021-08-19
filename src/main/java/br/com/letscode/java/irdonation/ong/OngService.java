package br.com.letscode.java.irdonation.ong;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        this.repository.deleteOngByCnpj(cnpj);
    }

}

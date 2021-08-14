package br.com.letscode.java.irdonation.ong;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OngService {

    private OngRepository ongRepository;

    public List<Ong> listAll() {
        return ongRepository.findAll();
    }

    public void cadastrarOng(Ong ong) {
        ongRepository.save(ong);
    }

    public void deleteById(Long cnpj) {
        ongRepository.deleteById(cnpj);
    }
}

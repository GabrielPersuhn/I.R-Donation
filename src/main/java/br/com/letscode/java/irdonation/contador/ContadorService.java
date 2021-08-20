package br.com.letscode.java.irdonation.contador;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContadorService {

    private final ContadorRepository repository;

    public List<Contador> listAll() {
        return this.repository.findAll();
    }

    public void cadastrarContador(Contador contador) {
        this.repository.save(contador);
    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    public Optional<Contador> findById(Integer id) {
        return this.repository.findById(id);
    }


}

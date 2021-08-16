package br.com.letscode.java.irdonation.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> listall() {
        return this.repository.findAll();
    }

    public List<Cliente> listNaoAtendidos() {
        return this.repository.findAll().stream().
                filter(Cliente::getFoiAtendido) // TODO teste de método
                .collect(Collectors.toList());
    }

    public void cadastrarCliente(Cliente cliente) {
        cliente.setFoiAtendido(false);
        this.repository.save(cliente);
    }

    public void deleteByCpf(Long cpf) {
        this.repository.deleteById(cpf);
    }

}

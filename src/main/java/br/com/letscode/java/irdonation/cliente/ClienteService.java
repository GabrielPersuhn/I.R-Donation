package br.com.letscode.java.irdonation.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public List<Cliente> listall() {
        return this.repository.findAll();
    }

    public Cliente newCliente(Cliente cliente) {
        return this.repository.save(cliente);
    }

}

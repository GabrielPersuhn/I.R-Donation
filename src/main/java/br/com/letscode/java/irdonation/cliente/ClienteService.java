package br.com.letscode.java.irdonation.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public LinkedList<Cliente> filaClientes() {
        List<Cliente> yourList = this.repository.findAll();
        return new LinkedList<>(yourList);
    }

    public void removerFila() {
        filaClientes().removeFirst();
    }

    public List<Cliente> listAll() {
        return this.repository.findAll();
    }

    public void cadastrarCliente(Cliente cliente) {
        this.repository.save(cliente);
    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

}

package br.com.letscode.java.irdonation.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listAll() {
        return this.clienteRepository.findAll();
    }

    public LinkedList<Cliente> filaClientes() {
        List<Cliente> yourList = this.clienteRepository.findAll();
        return new LinkedList<>(yourList);
    }

    public void cadastrarCliente(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    public void deleteById(Integer id) {
        this.clienteRepository.deleteById(id);
    }

    public void deleteClienteByIdOrderByIdAsc() {
        this.clienteRepository.deleteClienteByIdOrderByIdAsc();
    }

    public Optional<Cliente> findById(Integer id) {
        return this.clienteRepository.findById(id);
    }

}

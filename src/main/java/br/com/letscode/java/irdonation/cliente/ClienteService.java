package br.com.letscode.java.irdonation.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public Queue<Cliente> listall() {
        List<Cliente> yourList = this.repository.findAll();
        return new ArrayDeque<>(yourList);
    }

    public void cadastrarCliente(Cliente cliente) {
        cliente.setFoiAtendido(false);
        this.repository.save(cliente);
    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

}

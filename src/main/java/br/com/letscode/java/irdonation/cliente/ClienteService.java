package br.com.letscode.java.irdonation.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public Queue<Cliente> listall() {
        List<Cliente> yourList = this.repository.findAll();
        return new LinkedList<>(yourList);
    }

    public Queue<Cliente> listNaoAtendidos() {
        List<Cliente> yourList = this.repository.findAll();
        return new LinkedList<Cliente>(yourList);
    }

    public void cadastrarCliente(Cliente cliente) {
        cliente.setFoiAtendido(false);
        this.repository.save(cliente);
    }

    public void deleteByCpf(Long cpf) {
        this.repository.deleteById(cpf);
    }

}

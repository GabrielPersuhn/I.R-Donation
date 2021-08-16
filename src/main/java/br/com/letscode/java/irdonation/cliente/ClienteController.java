package br.com.letscode.java.irdonation.cliente;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    @GetMapping("/listarTodos")
    public List<Cliente> list() {
        return this.service.listall();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> criarcliente(@RequestBody Cliente cliente) {
        this.service.cadastrarCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> remover(@PathVariable Long cpf){
        try {
            service.deleteByCpf(cpf);
            return new ResponseEntity<>("CPF " + cpf + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("CPF " + cpf + " não encontrado", HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/{id}")
//    public Cliente alterarInformacoes(@PathVariable Long id, @RequestBody String imdbId, Authentication auth)    {
//        return this.service.answer(id, imdbId, auth.getName());
//    }

}


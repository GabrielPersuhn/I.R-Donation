package br.com.letscode.java.irdonation.cliente;

import br.com.letscode.java.irdonation.contador.ContadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ContadorService contadorService;

    private final ClienteService clienteService;

    @GetMapping("/listarClientes")
    public ResponseEntity<?> listallClientes() {
        System.out.println("A seguir listamos todos os clientes disponíveis na nossa plataforma. " +
                "Logo, um desses voluntários entrará em contato :) ");
        this.clienteService.listall();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listarContadores")
    public ResponseEntity<?> listallContadores() {
        System.out.println("A seguir listamos todos os contadores disponíveis na nossa plataforma. " +
                "Logo, um desses voluntários entrará em contato :) ");
        this.contadorService.listAll();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarCliente(@RequestBody Cliente cliente) {
        this.clienteService.cadastrarCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> remover(@PathVariable Long cpf){
        try {
            clienteService.deleteByCpf(cpf);
            return new ResponseEntity<>("CPF " + cpf + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("CPF " + cpf + " não encontrado", HttpStatus.NOT_FOUND);
        }
    }

}


package br.com.letscode.java.irdonation.cliente;

import br.com.letscode.java.irdonation.contador.ContadorResponse;
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
        var clientes = this.clienteService.listAll();
        return new ResponseEntity<>(ClienteResponse.convert(clientes), HttpStatus.OK);
    }

    @GetMapping("/listarContadores")
    public ResponseEntity<?> listallContadores() {
        try {
            var contadores = this.contadorService.listAll();
            return new ResponseEntity<>("A seguir listamos todos os contadores disponíveis na nossa plataforma. " +
                    "Logo, um desses voluntários entrará em contato. \n" + ContadorResponse.convert(contadores), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Não há contadores cadastrados", HttpStatus.OK);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarCliente(@RequestBody Cliente cliente) {
        this.clienteService.cadastrarCliente(cliente);
        return new ResponseEntity<>(cliente + " cadastrado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> remover(@PathVariable Long cpf) {
        try {
            var cliente = this.clienteService.findByCpf(cpf).get();
            this.clienteService.deleteByCpf(cpf);
            return new ResponseEntity<>(cliente + " removido com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cliente não encontrado", HttpStatus.OK);
        }
    }
}


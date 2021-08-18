package br.com.letscode.java.irdonation.contador;

import br.com.letscode.java.irdonation.cliente.Cliente;
import br.com.letscode.java.irdonation.cliente.ClienteResponse;
import br.com.letscode.java.irdonation.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contador")
public class ContadorController {

    private final ContadorService service;

    private final ClienteService clienteService;

    @GetMapping("/listarContadores")
    public ResponseEntity<?> list() {
        try {
            return new ResponseEntity<>(this.service.listAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Não há contadores cadastrados", HttpStatus.OK);
        }
    }

    @GetMapping("/atendimento")
    public ResponseEntity<?> listClientes()  {
        if (this.clienteService.filaClientes().isEmpty()) {
            return new ResponseEntity<>("Não há clientes cadastrados", HttpStatus.OK);
        }

        Cliente cliente = clienteService.filaClientes().getFirst();
        this.clienteService.removerFila();

        //var clientes = this.clienteService.listAll().get(0);
        //return new ResponseEntity<>(ClienteResponse.convert(cliente) +
                //" está esperando pelo seu atendimento :)", HttpStatus.OK);
        return new ResponseEntity<>(cliente +
                " está esperando pelo seu atendimento :)", HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarContador(@RequestBody Contador contador) {
        this.service.cadastrarContador(contador);
        return new ResponseEntity<>(contador + " cadastrado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> remover(@PathVariable Long cpf){
        try {
            service.deleteByCpf(cpf);
            return new ResponseEntity<>("CPF " + cpf + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("CPF " + cpf + " não encontrado", HttpStatus.OK);
        }
    }

}

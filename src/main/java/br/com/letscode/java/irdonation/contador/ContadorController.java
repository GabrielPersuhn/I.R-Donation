package br.com.letscode.java.irdonation.contador;

import br.com.letscode.java.irdonation.cliente.Cliente;
import br.com.letscode.java.irdonation.cliente.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contador")
public class ContadorController {

    private final ContadorService contadorService;

    private final ClienteService clienteService;

    @GetMapping("/listarContadores")
    public ResponseEntity<?> list() {
        try {
            var contadores = this.contadorService.listAll();
            return new ResponseEntity<>(ContadorResponse.convert(contadores), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Não há contadores cadastrados", HttpStatus.OK);
        }
    }

    @GetMapping("/atendimento")
    public ResponseEntity<?> listClientes()  {
        if (this.clienteService.filaClientes().isEmpty()) {
            return new ResponseEntity<>("Os clientes cadastrados já foram atendidos. " +
                    "Espere instantes para realizar nova consulta", HttpStatus.OK);
        }

        Cliente cliente = clienteService.filaClientes().getFirst();
        clienteService.deleteClienteByIdOrderByIdAsc();
        return new ResponseEntity<>(cliente +
                " está esperando pelo seu atendimento :)", HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarContador(@RequestBody Contador contador) {
        this.contadorService.cadastrarContador(contador);
        return new ResponseEntity<>(contador + " cadastrado com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> remover(@PathVariable Long cpf){
        try {
            var contador = this.contadorService.findByCpf(cpf).get();
            this.contadorService.deleteByCpf(cpf);
            return new ResponseEntity<>(contador + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Contador não encontrado", HttpStatus.OK);
        }
    }

}

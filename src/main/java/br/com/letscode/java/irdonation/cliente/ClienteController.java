package br.com.letscode.java.irdonation.cliente;

import br.com.letscode.java.irdonation.contador.Contador;
import br.com.letscode.java.irdonation.contador.ContadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ContadorService contadorService;

    private final ClienteService clienteService;

    @GetMapping("/listarContadores")
    public List<Contador> list() {

        System.out.println("A seguir listamos todos os contadores disponíveis na nossa plataforma. " +
                "Logo, um desses voluntários entrará em contato :) ");
        return this.contadorService.listAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Cliente> criarcliente(@RequestBody Cliente cliente) {
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

//    @PutMapping("/{id}")
//    public Cliente alterarInformacoes(@PathVariable Long id, @RequestBody String imdbId, Authentication auth)    {
//        return this.service.answer(id, imdbId, auth.getName());
//    }

}


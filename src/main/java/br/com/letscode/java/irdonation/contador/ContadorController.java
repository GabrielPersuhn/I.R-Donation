package br.com.letscode.java.irdonation.contador;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contador")
public class ContadorController {
    private final ContadorService service;

    @GetMapping("/listarTodos")
    public List<Contador> list() {
        return this.service.listAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Contador> criarContador(@RequestBody Contador contador) {
        this.service.cadastrarContador(contador);
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

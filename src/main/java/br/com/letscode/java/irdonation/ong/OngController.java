package br.com.letscode.java.irdonation.ong;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
@RestController
@RequestMapping("/ongs")
public class OngController {

    private final OngService ongService;

    @GetMapping("/listarTodos")
    public List<Ong> listarTodos() {
        return ongService.listAll();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Ong> cadastrarOng(@RequestBody Ong ong) {
        ongService.cadastrarOng(ong);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<?> remover(@PathVariable Long cnpj){
        try {
            ongService.deleteById(cnpj);
            return new ResponseEntity<>("CNPJ " + cnpj + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("CNPJ " + cnpj + " não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}

package br.com.letscode.java.irdonation.ong;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            ongService.deleteByCnpj(cnpj);
            return new ResponseEntity<>("CNPJ " + cnpj + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("CNPJ " + cnpj + " não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    //@PutMapping("/{id}")
//    public Ong alterarInformacoes(@PathVariable Long id, @RequestBody String imdbId, Authentication auth)    {
//        return this.service.answer(id, imdbId, auth.getName());
//    }
}

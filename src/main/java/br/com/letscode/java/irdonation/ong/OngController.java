package br.com.letscode.java.irdonation.ong;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
@RestController
@RequestMapping("/ongs")
public class OngController {

    private final OngService ongService;

    @GetMapping("/listarTodos")
    public ResponseEntity<?> listarTodos() {
        try {
            var ongList = this.ongService.listAll();
            return new ResponseEntity<>(OngResponse.convert(ongList), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Não há ong's cadastradas", HttpStatus.OK);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarOng(@RequestBody Ong ong) {
        this.ongService.cadastrarOng(ong);
        return new ResponseEntity<>(ong + " cadastrada com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<?> remover(@PathVariable Long cnpj){
        try {
            ongService.deleteByCnpj(cnpj);
            return new ResponseEntity<>("CNPJ " + cnpj + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("CNPJ " + cnpj + " não encontrado", HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerId(@PathVariable Integer id){
        try {
            ongService.deleteById(id);
            return new ResponseEntity<>("Ong " + id + " removida com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Ong " + id + " não encontrado", HttpStatus.OK);
        }
    }

}

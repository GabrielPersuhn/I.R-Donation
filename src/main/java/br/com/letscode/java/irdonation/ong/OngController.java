package br.com.letscode.java.irdonation.ong;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        } catch (Exception e) {
            return new ResponseEntity<>("Não há ong's cadastradas", HttpStatus.OK);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarOng(@RequestBody Ong ong) {
        this.ongService.cadastrarOng(ong);
        return new ResponseEntity<>(ong.getRazaoSocial() + " cadastrada com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<?> remover(@PathVariable Long cnpj) {
        try {
            var ong = this.ongService.findByCnpj(cnpj).get();
            this.ongService.deleteByCnpj(cnpj);
            return new ResponseEntity<>(ong + " removida com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Ong não encontrada", HttpStatus.OK);
        }
    }

}

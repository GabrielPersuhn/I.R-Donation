package br.com.letscode.java.irdonation.autenticacao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/listarUsuarios")
    public ResponseEntity<?> list() {
        try {
            return (ResponseEntity<?>) this.userRepository.findAll();
        }
        catch (Exception e) {
            return new ResponseEntity<>("Não há usuarios cadastrados", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> criarUser(@RequestBody User user) {
        String senhaCripto = new BCryptPasswordEncoder().encode(user.getPassword()); // salva a senha criptografada
        user.setPassWord(senhaCripto);
        this.userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> remover(@PathVariable String email){
        try {
            userRepository.findByEmail(email);
            return new ResponseEntity<>("Email: " + email + " removido com sucesso", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Email: " + email + " não encontrado", HttpStatus.NOT_FOUND);
        }
    }

}

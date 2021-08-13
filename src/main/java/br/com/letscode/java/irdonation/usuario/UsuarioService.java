package br.com.letscode.java.irdonation.usuario;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<Usuario> list() {
        return this.repository.findAll();
    }

}

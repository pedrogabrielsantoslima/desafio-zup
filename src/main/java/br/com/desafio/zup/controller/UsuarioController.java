package br.com.desafio.zup.controller;

import br.com.desafio.zup.dto.UsuarioDTO;
import br.com.desafio.zup.models.Usuario;
import br.com.desafio.zup.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = this.usuarioService.criar(usuarioDTO);

        UsuarioDTO usuarioCriado = UsuarioDTO.convertBy(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }
}

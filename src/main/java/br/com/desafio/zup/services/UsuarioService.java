package br.com.desafio.zup.services;

import br.com.desafio.zup.dto.UsuarioDTO;
import br.com.desafio.zup.exceptions.JaExisteUsuarioException;
import br.com.desafio.zup.exceptions.UsuarioNaoEncontradoException;
import br.com.desafio.zup.models.Usuario;
import br.com.desafio.zup.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criar(UsuarioDTO usuarioDTO){

        if(this.usuarioRepository.existsByEmailOrCpf(usuarioDTO.getEmail(), usuarioDTO.getCpf())){
            throw new JaExisteUsuarioException("Ja existe um usuario cadastrado com essas informações");
        }

        Usuario usuario = Usuario.convertBy(usuarioDTO);

        this.usuarioRepository.save(usuario);

        return usuario;
    }

    public Usuario consultarPorId(Integer id){
        Optional<Usuario> usuario = this.usuarioRepository.findById(id);

        return usuario.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario não encontrado"));
    }
}

package br.com.desafio.zup.services;

import br.com.desafio.zup.dto.VacinaDTO;
import br.com.desafio.zup.models.Usuario;
import br.com.desafio.zup.models.Vacina;
import br.com.desafio.zup.repository.VacinaRepository;
import org.springframework.stereotype.Service;

@Service
public class VacinaService {

    private final UsuarioService usuarioService;
    private final VacinaRepository vacinaRepository;

    public VacinaService(UsuarioService usuarioService, VacinaRepository vacinaRepository) {
        this.usuarioService = usuarioService;
        this.vacinaRepository = vacinaRepository;
    }

    public Vacina criar(VacinaDTO vacinaDTO){
        Usuario usuario = usuarioService.consultarPorId(vacinaDTO.getIdUsuario());

        Vacina vacina = Vacina.convertBy(vacinaDTO, usuario);

        this.vacinaRepository.save(vacina);

        return vacina;
    }
}

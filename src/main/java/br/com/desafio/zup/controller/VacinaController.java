package br.com.desafio.zup.controller;

import br.com.desafio.zup.dto.VacinaDTO;
import br.com.desafio.zup.models.Vacina;
import br.com.desafio.zup.services.VacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/vacinas")
public class VacinaController {

    private final VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    @PostMapping
    public ResponseEntity<VacinaDTO> criar(@Valid @RequestBody VacinaDTO vacinaDTO){
        Vacina vacina = this.vacinaService.criar(vacinaDTO);

        VacinaDTO vacinaCriada = VacinaDTO.convertBy(vacina);

        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaCriada);
    }
}

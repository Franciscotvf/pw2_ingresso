package br.com.etec.ingresso.CONTROLLER;

import br.com.etec.ingresso.ENTITY.Filme;
import br.com.etec.ingresso.ENUMS.ClassificacaoIndicativaENUM;
import br.com.etec.ingresso.ENUMS.SimNaoEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")

public class FilmeController {

    @GetMapping
    public List<Filme> listar(){
        Filme filme1 = Filme.builder().id(1L)
                .titulo("Matrix")
                .classificacao(ClassificacaoIndicativaENUM.A16)
                .cartaz(SimNaoEnum.S)
                .build();

        return List.of(filme1);
    }
}

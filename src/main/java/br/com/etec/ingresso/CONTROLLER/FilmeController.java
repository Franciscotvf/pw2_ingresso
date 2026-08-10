package br.com.etec.ingresso.CONTROLLER;

import br.com.etec.ingresso.ENTITY.Filme;
import br.com.etec.ingresso.ENUMS.ClassificacaoIndicativaENUM;
import br.com.etec.ingresso.ENUMS.SimNaoEnum;
import lombok.Builder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Builder
@RequestMapping("/filmes")

public class FilmeController {

    @GetMapping
    public List<Filme> listar() {
        Filme filme1 = Filme.builder()
                .id(1L) // Dado long
                .titulo("Matrix")
                .classificacao(ClassificacaoIndicativaENUM.A16)
                .cartaz(SimNaoEnum.S)
                .build();

        Filme filme2 = Filme.builder()
                .id(2L)
                .titulo("Avatar")
                .classificacao(ClassificacaoIndicativaENUM.A18)
                .cartaz(SimNaoEnum.S)
                .build();

        Filme filme3 = Filme.builder().id(3L)
                .titulo("Homem aranha: Um novo dia")
                .classificacao(ClassificacaoIndicativaENUM.A16)
                .cartaz(SimNaoEnum.N)
                .build();

        return List.of(filme1, filme2, filme3);
    }
    @GetMapping("/{id}") //Buscar variavel de filmes através de /{id}
    public Filme BuscarPorto(@PathVariable Long id){ //PathVariable para puxar os id
        Filme filme2 = Filme.builder()
                .id(id)
                .titulo("Avatar")
                .classificacao(ClassificacaoIndicativaENUM.A18)
                .cartaz(SimNaoEnum.S)
                .build();
        return filme2;


    }
    @PostMapping
    public Filme cadastrar(@RequestBody Filme filme){
        filme.setId(100L);
        return filme;
    }
}

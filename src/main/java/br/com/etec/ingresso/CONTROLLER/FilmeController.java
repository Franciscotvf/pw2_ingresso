package br.com.etec.ingresso.CONTROLLER;

import br.com.etec.ingresso.ENTITY.Filme;
import br.com.etec.ingresso.ENUMS.ClassificacaoIndicativaENUM;
import br.com.etec.ingresso.ENUMS.SimNaoEnum;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Builder
@RequestMapping("/filmes")

public class FilmeController {

    List<Long> idExistentes = List.of(1L, 2L, 3L);
    @GetMapping
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {
        if (idExistentes.contains(id)) {
            Filme filme1 = Filme.builder().id(1L)
                    .id(1L) // Dado long
                    .titulo("Matrix")
                    .classificacao(ClassificacaoIndicativaENUM.A16)
                    .cartaz(SimNaoEnum.S)
                    .build();

            Filme filme2 = Filme.builder().id(2L)
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

            return ResponseEntity.ok(filme1);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}") //Buscar variavel de filmes através de /{id}
    public Filme BuscarPorto(@PathVariable Long id){ //PathVariable para puxar os id
        Filme filme1 = Filme.builder()
                .id(id)
                .titulo("Matrix")
                .classificacao(ClassificacaoIndicativaENUM.A18)
                .cartaz(SimNaoEnum.S)
                .build();
        return filme1;


    }
    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme){
        filme.setId(100L);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme filme, @PathVariable Long id){
        if(idExistentes.contains(id)){
            return ResponseEntity.ok(filme);
        }
    return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        if(idExistentes.contains(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

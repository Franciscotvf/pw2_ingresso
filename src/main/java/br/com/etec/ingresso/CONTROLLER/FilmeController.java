package br.com.etec.ingresso.CONTROLLER;

import br.com.etec.ingresso.ENTITY.Filme;
import br.com.etec.ingresso.ENUMS.ClassificacaoIndicativaENUM;
import br.com.etec.ingresso.ENUMS.SimNaoEnum;
import br.com.etec.ingresso.REPOSITORY.FilmeRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")

public class    FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;


    List<Long> idExistentes = List.of(1L, 2L, 3L);
    @GetMapping
    public List<Filme> listar(){
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id) {
        var filme = filmeRepository.findById(id);
        if (filme.isPresent()) {
            return ResponseEntity.ok(filme.get());
        }

        return ResponseEntity.notFound().build();
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

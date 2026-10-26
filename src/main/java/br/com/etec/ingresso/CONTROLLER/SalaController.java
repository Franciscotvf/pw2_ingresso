package br.com.etec.ingresso.CONTROLLER;

import br.com.etec.ingresso.ENTITY.Sala;
import br.com.etec.ingresso.REPOSITORY.SalaRepository;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @GetMapping
    public List<Sala> listar() {
        return salaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id) {
        var sala = salaRepository.findById(id);
        if (sala.isPresent()) {
            return ResponseEntity.ok(sala.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sala> cadastrar(@RequestBody Sala sala) {
        var novaSala = salaRepository.save(sala);
        if (novaSala.getNome() != null && novaSala.getNome().length() >= 255)
        {
           return ResponseEntity.badRequest().build();
        }
        if (novaSala.getPreco() <= 5.00)
        {
            return ResponseEntity.badRequest().build();
        }
        if (novaSala.getDataExclusao() == null)
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSala);
    }
//exercicio
    @PutMapping("/{id}")
    public ResponseEntity<Sala> atualizar(@RequestBody Sala sala, @PathVariable Long id) {
        var existe = salaRepository.findById(id);
        if (sala.getNome() != null && sala.getNome().length() >= 255)
        {
            return ResponseEntity.badRequest().build();
        }
        if (sala.getPreco() <= 5.00)
        {
            return ResponseEntity.badRequest().build();
        }
        if (sala.getDataExclusao() == null)
        {
            return ResponseEntity.badRequest().build();
        }
        if (existe.isPresent()) {
            sala.setId(id); // Garante que o ID da entidade é o mesmo da URL
            var salaAtualizada = salaRepository.save(sala);
            return ResponseEntity.ok(salaAtualizada);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        var existe = salaRepository.findById(id);
        if (existe.isPresent()) {
            salaRepository.delete(existe.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
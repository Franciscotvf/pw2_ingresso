package br.com.etec.ingresso.REPOSITORY;


import br.com.etec.ingresso.ENTITY.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository  extends JpaRepository<Filme, Long>{


}

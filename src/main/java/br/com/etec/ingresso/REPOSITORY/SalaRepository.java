package br.com.etec.ingresso.REPOSITORY;


import br.com.etec.ingresso.ENTITY.Sala;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository  extends JpaRepository<Sala, Long>{

}
package br.com.etec.ingresso.ENTITY;

import br.com.etec.ingresso.ENUMS.CategoriaFilmeEnum;
import br.com.etec.ingresso.ENUMS.ClassificacaoIndicativaENUM;
import br.com.etec.ingresso.ENUMS.SimNaoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@NoArgsConstructor  //Construtor
@AllArgsConstructor //Construtor que pega todos
@Entity
@Table(name="TBL_SALA")

public class Sala {

    @Id
    @Column(name="ID_SALA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="TX_NOME")
    private String nome;

    @Column(name="NR_PRECO")
    private double preco;

    @Column(name="DT_EXCLUSAO")
    private LocalDateTime dataExclusao;
}

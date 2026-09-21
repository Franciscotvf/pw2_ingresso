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
@Table(name="TBL_FILME")
public class Filme {

    @Column(name="TX_NOME")
    private String nome;

    @Id
    @Column(name="ID_FILME")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name="NR_DURACAO")
    private Integer duracao;

    @Column(name="TP_CATEGORIA")
    @Enumerated(EnumType.STRING)
    private CategoriaFilmeEnum categoria;

    @Column(name="TP_CLASSIFICACAO")
    @Enumerated(EnumType.STRING)
    private ClassificacaoIndicativaENUM classificacao;

    @Column(name="NR_ANO")
    private Integer ano;

    @Column(name = "TX_CAPA")
    private String capa;

    @Column(name ="TX_DIRETOR")
    private String diretor;

    @Column(name="TX_ELENCO")
    private String elenco;

    @Column(name="TX_DESCRICAO")
    private String descricao;

    @Column(name="NR_AVALIACAO")
    private Double avaliacao;

    @Column(name="CHK_EM_CARTAZ")
    @Enumerated(EnumType.STRING)
    private SimNaoEnum emCartaz;

    @Transient
    private LocalDateTime dataExclusao;
}

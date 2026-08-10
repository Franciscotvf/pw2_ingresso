package br.com.etec.ingresso.ENTITY;

import br.com.etec.ingresso.ENUMS.CategoriaFilmeEnum;
import br.com.etec.ingresso.ENUMS.ClassificacaoIndicativaENUM;
import br.com.etec.ingresso.ENUMS.SimNaoEnum;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@AllArgsConstructor //Construtor que pega todos
@NoArgsConstructor //Construtor

public class Filme {
    private String titulo;
    private Long  id;
    private Integer duracao;
    private CategoriaFilmeEnum categoria;
    private ClassificacaoIndicativaENUM classificacao;
    private Integer ano;
    private String capa;
    private String diretor;
    private String elenco;
    private String descricao;
    private Double avaliacao;
    private SimNaoEnum cartaz;
    private LocalDateTime dataExclusao;
}

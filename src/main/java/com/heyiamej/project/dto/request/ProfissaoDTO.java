package com.heyiamej.project.dto.request;

import com.heyiamej.project.entity.Atividade;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfissaoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private List<Atividade> atividade;
}
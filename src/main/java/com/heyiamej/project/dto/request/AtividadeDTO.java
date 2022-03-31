package com.heyiamej.project.dto.request;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Integer nivel;

    private Integer profissao_id;

}
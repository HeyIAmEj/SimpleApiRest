package com.heyiamej.project.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.heyiamej.project.entity.Profissao;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String sobrenome;

    @NotEmpty
    @CPF
    private String documento;

    @Valid
    private String dataNascimento;

    private Profissao profissao;
    private Integer nivel;


}
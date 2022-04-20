package com.heyiamej.project.dto.mapper;

import com.heyiamej.project.dto.request.AtividadeDTO;
import com.heyiamej.project.dto.request.AtividadeDTO.AtividadeDTOBuilder;
import com.heyiamej.project.entity.Atividade;
import com.heyiamej.project.entity.Atividade.AtividadeBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-11T20:00:06-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class AtividadeMapperImpl implements AtividadeMapper {

    @Override
    public Atividade toAtividade(AtividadeDTO atividadeDTO) {
        if ( atividadeDTO == null ) {
            return null;
        }

        AtividadeBuilder atividade = Atividade.builder();

        atividade.id( atividadeDTO.getId() );
        atividade.nome( atividadeDTO.getNome() );
        atividade.descricao( atividadeDTO.getDescricao() );
        atividade.nivel( atividadeDTO.getNivel() );
        atividade.profissao_id( atividadeDTO.getProfissao_id() );

        return atividade.build();
    }

    @Override
    public AtividadeDTO toDTO(Atividade atividade) {
        if ( atividade == null ) {
            return null;
        }

        AtividadeDTOBuilder atividadeDTO = AtividadeDTO.builder();

        atividadeDTO.id( atividade.getId() );
        atividadeDTO.nome( atividade.getNome() );
        atividadeDTO.descricao( atividade.getDescricao() );
        atividadeDTO.nivel( atividade.getNivel() );
        atividadeDTO.profissao_id( atividade.getProfissao_id() );

        return atividadeDTO.build();
    }
}

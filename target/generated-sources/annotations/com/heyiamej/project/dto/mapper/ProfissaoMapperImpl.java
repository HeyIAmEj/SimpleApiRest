package com.heyiamej.project.dto.mapper;

import com.heyiamej.project.dto.request.ProfissaoDTO;
import com.heyiamej.project.dto.request.ProfissaoDTO.ProfissaoDTOBuilder;
import com.heyiamej.project.entity.Atividade;
import com.heyiamej.project.entity.Profissao;
import com.heyiamej.project.entity.Profissao.ProfissaoBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-11T20:00:06-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ProfissaoMapperImpl implements ProfissaoMapper {

    @Override
    public Profissao toProfissao(ProfissaoDTO profissaoDTO) {
        if ( profissaoDTO == null ) {
            return null;
        }

        ProfissaoBuilder profissao = Profissao.builder();

        profissao.id( profissaoDTO.getId() );
        profissao.nome( profissaoDTO.getNome() );
        profissao.descricao( profissaoDTO.getDescricao() );
        List<Atividade> list = profissaoDTO.getAtividade();
        if ( list != null ) {
            profissao.atividade( new ArrayList<Atividade>( list ) );
        }

        return profissao.build();
    }

    @Override
    public ProfissaoDTO toDTO(Profissao profissao) {
        if ( profissao == null ) {
            return null;
        }

        ProfissaoDTOBuilder profissaoDTO = ProfissaoDTO.builder();

        profissaoDTO.id( profissao.getId() );
        profissaoDTO.nome( profissao.getNome() );
        profissaoDTO.descricao( profissao.getDescricao() );
        List<Atividade> list = profissao.getAtividade();
        if ( list != null ) {
            profissaoDTO.atividade( new ArrayList<Atividade>( list ) );
        }

        return profissaoDTO.build();
    }
}

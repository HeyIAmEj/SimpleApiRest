package com.heyiamej.project.dto.mapper;

import com.heyiamej.project.dto.request.ProfissaoDTO;
import com.heyiamej.project.entity.Profissao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfissaoMapper {

    ProfissaoMapper INSTANCE = Mappers.getMapper(ProfissaoMapper.class);

    //@Mapping(source="dataNascimento", target="dataNascimento", dateFormat="dd-MM-yyyy")
    Profissao toProfissao(ProfissaoDTO profissaoDTO);

    ProfissaoDTO toDTO(Profissao profissao);

}
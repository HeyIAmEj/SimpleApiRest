package com.heyiamej.project.dto.mapper;

import com.heyiamej.project.dto.request.AtividadeDTO;
import com.heyiamej.project.entity.Atividade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AtividadeMapper {

    AtividadeMapper INSTANCE = Mappers.getMapper(AtividadeMapper.class);

    //@Mapping(source="dataNascimento", target="dataNascimento", dateFormat="dd-MM-yyyy")
    Atividade toAtividade(AtividadeDTO atividadeDTO);

    AtividadeDTO toDTO(Atividade atividade);

}
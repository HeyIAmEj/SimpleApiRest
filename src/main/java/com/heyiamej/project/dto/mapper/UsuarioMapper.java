package com.heyiamej.project.dto.mapper;

import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.entity.Usuario;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source="dataNascimento", target="dataNascimento", dateFormat="dd/MM/yyyy")
    Usuario toUsuario(UsuarioDTO UsuarioDTO);

    UsuarioDTO toDTO(Usuario Usuario);

}
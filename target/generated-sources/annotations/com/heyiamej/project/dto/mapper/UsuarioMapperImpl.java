package com.heyiamej.project.dto.mapper;

import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.dto.request.UsuarioDTO.UsuarioDTOBuilder;
import com.heyiamej.project.entity.Usuario;
import com.heyiamej.project.entity.Usuario.UsuarioBuilder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T21:17:22-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toUsuario(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        UsuarioBuilder usuario = Usuario.builder();

        if ( usuarioDTO.getDataNascimento() != null ) {
            usuario.dataNascimento( LocalDate.parse( usuarioDTO.getDataNascimento(), DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) ) );
        }
        usuario.id( usuarioDTO.getId() );
        usuario.nome( usuarioDTO.getNome() );
        usuario.sobrenome( usuarioDTO.getSobrenome() );
        usuario.cpf( usuarioDTO.getCpf() );
        usuario.email( usuarioDTO.getEmail() );
        usuario.senha( usuarioDTO.getSenha() );
        usuario.permissao( usuarioDTO.getPermissao() );
        usuario.nivel( usuarioDTO.getNivel() );
        usuario.profissao( usuarioDTO.getProfissao() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.id( usuario.getId() );
        usuarioDTO.nome( usuario.getNome() );
        usuarioDTO.sobrenome( usuario.getSobrenome() );
        usuarioDTO.cpf( usuario.getCpf() );
        usuarioDTO.email( usuario.getEmail() );
        usuarioDTO.senha( usuario.getSenha() );
        usuarioDTO.permissao( usuario.getPermissao() );
        if ( usuario.getDataNascimento() != null ) {
            usuarioDTO.dataNascimento( DateTimeFormatter.ISO_LOCAL_DATE.format( usuario.getDataNascimento() ) );
        }
        usuarioDTO.profissao( usuario.getProfissao() );
        usuarioDTO.nivel( usuario.getNivel() );

        return usuarioDTO.build();
    }
}

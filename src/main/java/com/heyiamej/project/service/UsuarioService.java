package com.heyiamej.project.service;

import com.heyiamej.project.dto.mapper.UsuarioMapper;
import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Usuario;
import com.heyiamej.project.exception.UsuarioNaoEncontradaException;
import com.heyiamej.project.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;



    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public MessageResponseDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
        Usuario usuarioSalva = usuarioRepository.save(usuario);
        return criarMensagemResposta("Usuario criada com Id: ", usuarioSalva);

    }

    public List<UsuarioDTO> listAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios
                .stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id) throws UsuarioNaoEncontradaException {
        Usuario usuario = verifyIfExists(id);
        return usuarioMapper.toDTO(usuario);
    }

    private Usuario verifyIfExists(Long id) throws UsuarioNaoEncontradaException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradaException(id));
    }

    public void deleteUsuarioById(Long id) throws UsuarioNaoEncontradaException {
        verifyIfExists(id);
        usuarioRepository.deleteById(id);
    }


    public MessageResponseDTO atualizarUsuarioById(Long id, UsuarioDTO usuarioDTO) throws UsuarioNaoEncontradaException {
        verifyIfExists(id);
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
        Usuario usuarioSalva = usuarioRepository.save(usuario);
        return criarMensagemResposta("Usuario Atualizado com Id: ", usuarioSalva);
    }

    private MessageResponseDTO criarMensagemResposta(String x, Usuario usuarioSalva) {
        return MessageResponseDTO.builder().message(x + usuarioSalva.getId()).build();
    }

}
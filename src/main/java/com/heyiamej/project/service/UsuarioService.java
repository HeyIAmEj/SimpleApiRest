package com.heyiamej.project.service;

import com.heyiamej.project.dto.mapper.UsuarioMapper;
import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Usuario;
import com.heyiamej.project.exception.UsuarioNaoEncontradoException;
import com.heyiamej.project.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MessageResponseDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
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

    public UsuarioDTO findById(Long id) throws UsuarioNaoEncontradoException {
        Usuario usuario = verifyIfExists(id);
        return usuarioMapper.toDTO(usuario);
    }

    public Usuario findByEmail(String email) throws UsuarioNaoEncontradoException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) return usuario;
        else throw new UsuarioNaoEncontradoException("Não foi encontrado um usuario com email " + email);
    }

    private Usuario verifyIfExists(Long id) throws UsuarioNaoEncontradoException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }


    public void deleteUsuarioById(Long id) throws UsuarioNaoEncontradoException {
        verifyIfExists(id);
        usuarioRepository.deleteById(id);
    }


    public MessageResponseDTO atualizarUsuarioById(Long id, UsuarioDTO usuarioDTO) throws UsuarioNaoEncontradoException {
        verifyIfExists(id);
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
        Usuario usuarioSalva = usuarioRepository.save(usuario);
        return criarMensagemResposta("Usuario Atualizado com Id: ", usuarioSalva);
    }

    private MessageResponseDTO criarMensagemResposta(String x, Usuario usuarioSalva) {
        return MessageResponseDTO.builder().message(x + usuarioSalva.getId()).build();
    }

    public UsuarioDTO authUsuario(String email, String senha) {
        Usuario usuario = usuarioRepository.auth(email, senha);
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getPermissao()));
        if(usuario != null) return new org.springframework.security.core.userdetails.
            User(usuario.getEmail(), usuario.getSenha(), authorities);
        else throw new UsernameNotFoundException("Usuario com email "+email+" não encontrado!");
    }
}
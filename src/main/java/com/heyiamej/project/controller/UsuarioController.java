package com.heyiamej.project.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Usuario;
import com.heyiamej.project.exception.UsuarioNaoEncontradoException;
import com.heyiamej.project.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired(required = true)
    public UsuarioController(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    }


    @Operation(summary = "Cria Usuario")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return usuarioService.createUsuario(usuarioDTO);
    }


    @Operation(summary = "Cria Usuario")
    @PostMapping("/auth")
    @ResponseStatus(value = HttpStatus.CREATED)
    public UsuarioDTO autenticarUsuario(@RequestBody Map<String, String> usuarioData) {
        String email = usuarioData.get("email");
        String senha = usuarioData.get("senha");
        return usuarioService.authUsuario(email, senha);
    }



    @Operation(summary = "Lista todas Usuarios")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<UsuarioDTO> listarTodasUsuarios(){
        return usuarioService.listAll();
    }

    @Operation(summary = "Lista Usuario por Id")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UsuarioDTO listarPorId(@PathVariable Long id)  throws UsuarioNaoEncontradoException {
        return usuarioService.findById(id);
    }


    @Operation(summary = "Atualiza Usuario por Id")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public MessageResponseDTO atualizarPorId(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO)  throws UsuarioNaoEncontradoException {
        return usuarioService.atualizarUsuarioById(id, usuarioDTO);
    }

    @Operation(summary = "Deleta Usuario por Id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id)  throws UsuarioNaoEncontradoException {
        usuarioService.deleteUsuarioById(id);
    }
    

}


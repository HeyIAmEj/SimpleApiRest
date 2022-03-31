package com.heyiamej.project.controller;

import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.exception.UsuarioNaoEncontradaException;
import com.heyiamej.project.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @Operation(summary = "Lista todas Usuarios")
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<UsuarioDTO> listarTodasUsuarios(){
        return usuarioService.listAll();
    }

    @Operation(summary = "Lista Usuario por Id")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public UsuarioDTO listarPorId(@PathVariable Long id)  throws UsuarioNaoEncontradaException {
        return usuarioService.findById(id);
    }

    @Operation(summary = "Atualiza Usuario por Id")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public MessageResponseDTO atualizarPorId(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO)  throws UsuarioNaoEncontradaException {
        return usuarioService.atualizarUsuarioById(id, usuarioDTO);
    }

    @Operation(summary = "Deleta Usuario por Id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Long id)  throws UsuarioNaoEncontradaException {
        usuarioService.deleteUsuarioById(id);
    }
    

}
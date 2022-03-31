package com.heyiamej.project.controller;


import com.heyiamej.project.dto.request.ProfissaoDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Profissao;
import com.heyiamej.project.exception.ProfissaoNaoEncontradaException;
import com.heyiamej.project.service.ProfissaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profissoes")
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    @Autowired
    public ProfissaoController(ProfissaoService profissaoService) {
        this.profissaoService = profissaoService;
    }

    // Cria nova Profissao
    @Operation(summary = "Cria nova Profissão")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criaProfissao(@RequestBody ProfissaoDTO profissaoDTO){
        return profissaoService.createProfissao(profissaoDTO);
    }

    // Ver Profissoes
    @Operation(summary = "Lista todas as Profissões")
    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Profissao> verProfissao() {
        return profissaoService.getAllProfissao();
    }
    // Ver Profissao por Id
    @Operation(summary = "Lista Profissão por Id")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Profissao verProfissaoPorId(@PathVariable Long id) throws ProfissaoNaoEncontradaException {
        return profissaoService.getProfissaoById(id);
    }

    // Atualiza uma Profissao por Id
    @Operation(summary = "Atualiza Profissão por Id")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO atualizaProfissaoPorId(@PathVariable Long id, @RequestBody ProfissaoDTO profissaoDTO) throws ProfissaoNaoEncontradaException {
        return profissaoService.updateProfissaoById(id, profissaoDTO);
    }

    // Deleta uma Profissao por Id
    @Operation(summary = "Deleta Profissão por Id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String deletaProfissaoPorId(@PathVariable Long id) {
        return "Deletado";
    }
}
package com.heyiamej.project.controller;


import com.heyiamej.project.dto.request.AtividadeDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Atividade;
import com.heyiamej.project.exception.AtividadeNaoEncontradaException;
import com.heyiamej.project.service.AtividadeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/atividades")
public class AtividadeController {

    private final AtividadeService atividadeService;

    @Autowired
    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    // Cria nova Atividade
    @Operation(summary = "Cria nova atividade")
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO criaAtividade(@RequestBody AtividadeDTO atividadeDTO){
        return atividadeService.createAtividade(atividadeDTO);
    }

    // Ver todas atividades
    @Operation(summary = "Lista todas as atividades")
    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public List<Atividade> verAtividadePorId() {
        return atividadeService.getAllAtividade();
    }
    // Ver Atividade por Id
    @Operation(summary = "Lista uma atividade por Id")
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Atividade verAtividadePorId(@PathVariable Long id) throws AtividadeNaoEncontradaException {
        return atividadeService.getAtividadeById(id);
    }

    // Atualiza uma Atividade por Id
    @Operation(summary = "Atualiza uma atividade por Id")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MessageResponseDTO atualizaAtividadePorId(@PathVariable Long id, @RequestBody AtividadeDTO atividadeDTO) throws AtividadeNaoEncontradaException {
        return atividadeService.updateAtividadeById(id, atividadeDTO);
    }

    // Deleta uma Atividade por Id
    @Operation(summary = "Deleta uma atividade por Id")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String deletaAtividadePorId(@PathVariable Long id) {
        return "Deletado";
    }
}
package com.heyiamej.project.controller;

import com.heyiamej.project.dto.request.AtividadeDTO;
import com.heyiamej.project.dto.request.ProfissaoDTO;
import com.heyiamej.project.dto.request.UsuarioDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Profissao;
import com.heyiamej.project.exception.ProfissaoNaoEncontradaException;
import com.heyiamej.project.exception.UsuarioNaoEncontradaException;
import com.heyiamej.project.repository.AtividadeRepository;
import com.heyiamej.project.repository.ProfissaoRepository;
import com.heyiamej.project.service.AtividadeService;
import com.heyiamej.project.service.ProfissaoService;
import com.heyiamej.project.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/testes")
public class TestesController {

    @Autowired
    private UsuarioController usuarioController;
    @Autowired
    private ProfissaoRepository profissaoRepository;
    @Autowired
    private AtividadeRepository atividadeRepository;
    @Autowired
    private ProfissaoService profissaoService;
    @Autowired
    private AtividadeService atividadeService;
    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Cria Todos os Testes")
    @GetMapping()
    @ResponseStatus(value = HttpStatus.OK)
    public String criarTodosTestes() throws ProfissaoNaoEncontradaException {
        //Criando Profissões
        MessageResponseDTO teste = profissaoService.createProfissao(new ProfissaoDTO(1L, "Ciência da Computação", "CCO", null));
        teste = profissaoService.createProfissao(new ProfissaoDTO(2L, "Recursos Humanos", "RH", null));
        teste = profissaoService.createProfissao(new ProfissaoDTO(3L, "Técnico em Manutenção", "TM", null));

        //Criando Atividades
        teste = atividadeService.createAtividade(new AtividadeDTO(1L, "Desenvolver API Basica", "Conceitos básicos de API", 3, 1));
        teste = atividadeService.createAtividade(new AtividadeDTO(2L, "Mentoria Junior", "Mentoria aos Juniores", 2, 1));
        teste = atividadeService.createAtividade(new AtividadeDTO(3L, "Reuniões de Planejamento", "Reuniões de planejamento e contratos com Cliente", 1, 1));
        teste = atividadeService.createAtividade(new AtividadeDTO(4L, "Efetivação de Usuarios", "Efetivação de contratos de usuarios", 1, 2));
        teste = atividadeService.createAtividade(new AtividadeDTO(5L, "Processos Seletivos", "Planejamento de processos seletivos", 3, 2));
        teste = atividadeService.createAtividade(new AtividadeDTO(6L, "Arquitetura de Softwares", "Desenvolvimento de arquiteturas para softwares", 1, 1));

        Profissao profissao1 = profissaoService.getProfissaoById(1L);
        Profissao profissao2 = profissaoService.getProfissaoById(2L);
        Profissao profissao3 = profissaoService.getProfissaoById(3L);

        //Criando Usuarios
        teste = usuarioService.createUsuario(new UsuarioDTO(1L, "Everton", "Jose", "748.682.614-36", "03/07/1999", profissao1, 1));
        teste = usuarioService.createUsuario(new UsuarioDTO(2L, "Maria", "Soares", "256.346.596-63", "03/07/1999", profissao1, 1));
        teste = usuarioService.createUsuario(new UsuarioDTO(3L, "Mariana", "Santos", "088.117.483-13", "03/07/1999", profissao1, 2));
        teste = usuarioService.createUsuario(new UsuarioDTO(4L, "Jose", "Silva", "603.836.852-30", "03/07/1999", profissao1, 3));
        teste = usuarioService.createUsuario(new UsuarioDTO(5L, "Bruna", "Lopes", "682.058.527-66", "03/07/1999", profissao2, 1));
        teste = usuarioService.createUsuario(new UsuarioDTO(6L, "Armando", "Silva", "424.397.284-20", "03/07/1999", profissao2, 2));
        teste = usuarioService.createUsuario(new UsuarioDTO(7L, "Clóvis", "Santos", "754.767.541-72", "03/07/1999", profissao3, 3));
        teste = usuarioService.createUsuario(new UsuarioDTO(8L, "Marta", "Pereira", "948.778.826-34", "03/07/1999", profissao3, 2));
        return "Profissões/Atividades/Usuarios Criadas";
    }
}
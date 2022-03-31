package com.heyiamej.project.service;


import com.heyiamej.project.dto.mapper.ProfissaoMapper;
import com.heyiamej.project.dto.request.ProfissaoDTO;
import com.heyiamej.project.dto.response.MessageResponseDTO;
import com.heyiamej.project.entity.Profissao;
import com.heyiamej.project.exception.ProfissaoNaoEncontradaException;
import com.heyiamej.project.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoService {
    private final ProfissaoRepository profissaoRepository;
    private final ProfissaoMapper profissaoMapper = ProfissaoMapper.INSTANCE;
    @Autowired
    public ProfissaoService(ProfissaoRepository profissaoRepository) {
        this.profissaoRepository = profissaoRepository;
    }


    public MessageResponseDTO criarResposta(Profissao profissao){
        return MessageResponseDTO.builder().message("Profissão: "+profissao.getNome()+" salva com id: "+profissao.getId()).build();
    }

    // Criar Profissao
    public MessageResponseDTO createProfissao(ProfissaoDTO profissaoDTO){
        Profissao profissao = profissaoMapper.toProfissao(profissaoDTO);
        Profissao profissaoSalva = profissaoRepository.save(profissao);
        return criarResposta(profissaoSalva);
    }

    // Ver Profissao
    public Profissao getProfissaoById(Long id) throws ProfissaoNaoEncontradaException {
        Profissao profissaoSalva = verifyIfExists(id);
        return profissaoSalva;
    }

    // Ver Profissoes
    public List<Profissao> getAllProfissao(){
        List<Profissao> profissaoList = profissaoRepository.findAll();
        return profissaoList;
    }

    public Profissao verifyIfExists(Long id) throws ProfissaoNaoEncontradaException {
        return profissaoRepository.findById(id)
                .orElseThrow(() -> new ProfissaoNaoEncontradaException(id));
    }

    // Atualizar Profissao
    public MessageResponseDTO updateProfissaoById(Long id, ProfissaoDTO profissaoDTO) throws ProfissaoNaoEncontradaException {
        verifyIfExists(id);
        Profissao profissao = profissaoMapper.toProfissao(profissaoDTO);
        Profissao profissaoSalva = profissaoRepository.save(profissao);
        return criarResposta(profissaoSalva);
    }


    // Deletar Profissao
    public void deleteProfissaoById(Long id) throws ProfissaoNaoEncontradaException {
        verifyIfExists(id);
        profissaoRepository.deleteById(id);
    }
}
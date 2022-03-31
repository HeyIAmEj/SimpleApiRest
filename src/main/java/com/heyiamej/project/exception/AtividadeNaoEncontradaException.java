package com.heyiamej.project.exception;

public class AtividadeNaoEncontradaException extends Exception {
    public AtividadeNaoEncontradaException(Long id) {
        super(String.format("Atividade com id %d não encontrada!", id));
    }
}
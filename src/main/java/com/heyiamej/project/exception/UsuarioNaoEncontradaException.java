package com.heyiamej.project.exception;

public class UsuarioNaoEncontradaException extends Exception {
    public UsuarioNaoEncontradaException(Long id) {
        super(String.format("Usuario com id %d não encontrado!", id));
    }
}
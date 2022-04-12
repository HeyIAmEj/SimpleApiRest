package com.heyiamej.project.exception;

public class UsuarioNaoEncontradoException extends Exception {
    public UsuarioNaoEncontradoException(Long id) {
        super(String.format("Usuario com id %d não encontrado!", id));
    }

    public UsuarioNaoEncontradoException(String email) {
        super(String.format("Usuario com email %s não encontrado!", email));
    }
}
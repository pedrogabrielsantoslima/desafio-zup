package br.com.desafio.zup.exceptions;

public class JaExisteUsuarioException extends RuntimeException {

    public JaExisteUsuarioException(String mensagem){
        super(mensagem);
    }
}

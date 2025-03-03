package br.com.cauaalves.gestao_filmes.Exceptions;

public class SessionFound extends RuntimeException{
    public SessionFound() {
        super("Sessão já encontrada");
    }
}

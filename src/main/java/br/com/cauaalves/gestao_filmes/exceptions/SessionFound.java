package br.com.cauaalves.gestao_filmes.exceptions;

public class SessionFound extends RuntimeException{
    public SessionFound() {
        super("Sessão já encontrada");
    }
}

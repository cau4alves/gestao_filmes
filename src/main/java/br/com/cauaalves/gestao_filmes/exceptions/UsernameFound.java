package br.com.cauaalves.gestao_filmes.Exceptions;

public class UsernameFound extends RuntimeException{
    public UsernameFound() {
        super("Usuário já existe");
    }
}

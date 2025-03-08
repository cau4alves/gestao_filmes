package br.com.cauaalves.gestao_filmes.exceptions;

public class UsernameFound extends RuntimeException{
    public UsernameFound() {
        super("Usuário já existe");
    }
}

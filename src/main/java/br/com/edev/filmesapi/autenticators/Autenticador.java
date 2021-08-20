package br.com.edev.filmesapi.autenticators;


import br.com.edev.filmesapi.entities.Filmes;

public interface Autenticador {

    void autentica(String nome, String diretor, String data);

}

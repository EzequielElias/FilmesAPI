package br.com.edev.filmesapi.autenticators;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;

@Component
public class AutenticadorNome implements Autenticador{

    private static HashSet<Filmes> filmes = new LinkedHashSet();

    @Override
    public void autentica(String nome, String diretor, String data) {

        boolean autenticador = false;
        autenticador = filmes.stream().anyMatch(f -> f.getNomeFilme().equalsIgnoreCase(nome));
        if (autenticador = true) throw new FilmeJaExistenteException();

    }
}

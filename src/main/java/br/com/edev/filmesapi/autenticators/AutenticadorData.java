package br.com.edev.filmesapi.autenticators;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AutenticadorData implements Autenticador {

    private static HashSet<Filmes> filmes = new HashSet<>();

    @Override
    public void autentica(String nome, String diretor, String data) {

        boolean autenticador = false;
        autenticador = filmes.stream().anyMatch(flm -> flm.getDataLancamento().equalsIgnoreCase(data));

        if (autenticador = true) throw new FilmeJaExistenteException();
        }
}

package br.com.edev.filmesapi.autenticators;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AutenticadorDiretor implements Autenticador {

    private static HashSet<Filmes> filmes = new LinkedHashSet();

    @Override
    public void autentica(String nome, String diretor, String data) {

        boolean autenticador = false;
        autenticador = filmes.stream().anyMatch(flm -> flm.getNomeDiretor().equalsIgnoreCase(diretor));

        if (autenticador = true) throw new FilmeJaExistenteException();
        }
}

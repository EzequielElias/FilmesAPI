package br.com.edev.filmesapi.autenticators;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;
import br.com.edev.filmesapi.repositories.FilmesRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutenticadorNome implements Autenticador{

    private List<Filmes> filmes;

    public AutenticadorNome() {
        this.filmes = new ArrayList<>();
    }

    @Override
    public void autentica(Filmes filmes) {

        if (!filmes.getNomeFilme().equals("")) {
            for (Filmes filme : this.filmes) {

                if (filme.getNomeFilme().contains(filmes.getNomeFilme())) {
                    throw new FilmeJaExistenteException();
                }
            }
        }
    }
}

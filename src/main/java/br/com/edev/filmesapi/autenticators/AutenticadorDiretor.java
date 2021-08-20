package br.com.edev.filmesapi.autenticators;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutenticadorDiretor implements Autenticador {

    private List<Filmes> filmes;

    public AutenticadorDiretor() {
        this.filmes = new ArrayList<>();
    }

    @Override
    public void autentica(Filmes filmes) {

            if (!filmes.getNomeDiretor().equals("")) {
                for (Filmes filme : this.filmes) {

                    if (filme.getNomeDiretor().contains(filmes.getNomeDiretor())) {
                        throw new FilmeJaExistenteException();
                    }
                }
            }
        }
}

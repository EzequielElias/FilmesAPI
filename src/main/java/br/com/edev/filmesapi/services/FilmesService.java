package br.com.edev.filmesapi.services;

import br.com.edev.filmesapi.autenticators.Autenticador;
import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Service
public class FilmesService implements IFilmesService {

    private FilmesRepository filmesRepository = FilmesRepository.getInstance();

    @Autowired
    private List<Autenticador> autenticators;

    public List<Filmes> encontrarFilme() {
        return filmesRepository.encontrarFilme();
        }

    public List<Filmes> encontrarFilmesNome(String nome) {
            return filmesRepository.encontrarFilmeNome(nome);
        }

    public List<Filmes> encontrarFilmesDiretor(String diretor) {
            return filmesRepository.encontrarFilmeDiretor(diretor);
        }

    public List<Filmes> encontrarFilmesData(Date data) {
            return filmesRepository.encontrarFilmeDataLancamento(data);
        }

    public void cadastrarFilme(final Filmes filmes) {
        autenticators.forEach(autenticador -> autenticador.autentica(filmes));
        filmesRepository.cadastrarFilme(filmes);
    }

    public void editarFilme(final Filmes filmes) {
         filmesRepository.editarFilme(filmes);
        }

    public void deletarFilme(@PathVariable("id") Integer id) {
        filmesRepository.deletarFilme(id);
        }

}

package br.com.edev.filmesapi.services;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class FilmesService implements IFilmesService{

    @Autowired
    private FilmesRepository filmesRepository;

    public List<Filmes> encontrarFilmes() {
        return filmesRepository.encontrarFilmes();
        }

    public List<Filmes> encontrarFilmesNome(String nome) {
            return filmesRepository.encontrarFilmesNome(nome);
        }

    public List<Filmes> encontrarFilmesDiretor(String diretor) {
            return filmesRepository.encontrarFilmesDiretor(diretor);
        }

    public Filmes cadastrarFilme(final Filmes filmes){
        return filmesRepository.cadastrarFilme(filmes);
        }

    public void editarFilme(final Filmes filmes){
        filmesRepository.editarFilme(filmes);
        }

    public void deletarFilme(@PathVariable("id") Integer id) {
        filmesRepository.deletarFilme(id);
        }

}
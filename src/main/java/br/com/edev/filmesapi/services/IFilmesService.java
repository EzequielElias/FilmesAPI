package br.com.edev.filmesapi.services;

import br.com.edev.filmesapi.entities.Filmes;

import java.util.Date;
import java.util.List;

public interface IFilmesService {

    List<Filmes> encontrarFilme();
    List<Filmes> encontrarFilmesNome(String nome);
    List<Filmes> encontrarFilmesDiretor(String diretor);
    List<Filmes> encontrarFilmesData(Date data);
    void cadastrarFilme(final Filmes filmes);
    void editarFilme(final Filmes filmes);
    void deletarFilme(Integer id);

}

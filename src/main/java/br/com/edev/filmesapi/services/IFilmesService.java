package br.com.edev.filmesapi.services;

import br.com.edev.filmesapi.entities.Filmes;

import java.util.*;

public interface IFilmesService {

    List<Filmes> encontrarFilmes();
    List<Filmes> encontrarFilmesNome(String nome);
    List<Filmes> encontrarFilmesDiretor(String diretor);
    Filmes cadastrarFilme(final Filmes filmes);
    void editarFilme(final Filmes filmes);
    void deletarFilme(Integer id);

}

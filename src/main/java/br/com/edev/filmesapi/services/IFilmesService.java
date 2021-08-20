package br.com.edev.filmesapi.services;

import br.com.edev.filmesapi.entities.Filmes;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public interface IFilmesService {

    HashSet<Filmes> encontrarFilme();
    HashSet<Filmes> encontrarFilmesNome(String nome);
    HashSet<Filmes> encontrarFilmesDiretor(String diretor);
    HashSet<Filmes> encontrarFilmesData(String data);
    void cadastrarFilme(final Filmes filmes);
    void editarFilme(final Filmes filmes);
    void deletarFilme(Integer id);

}

package br.com.edev.filmesapi.repositories;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.exceptions.FilmeInexistenteException;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FilmesRepository {

    private final List<Filmes> filmes;
    private FilmesRepository() {
        this.filmes = new ArrayList<>();
    }
    private static FilmesRepository filmesRepository;


    public static FilmesRepository getInstance() {
        if(filmesRepository == null) {
            filmesRepository = new FilmesRepository();
        }
        return filmesRepository;
    }

    public List<Filmes> encontrarFilme() {
        return filmes;
    }

   public List<Filmes> encontrarFilmeNome(final String nome) {

        List<Filmes> filmesEncontrados = new ArrayList<>(filmes.stream().filter(flm -> flm.getNomeFilme().contains(nome)).collect(Collectors.toList()));

        if(filmesEncontrados.isEmpty()) {
            throw new FilmeInexistenteException();
        }
            return filmesEncontrados;
    }

   public List<Filmes> encontrarFilmeDiretor(final String diretor) {

        List<Filmes> filmesEncontrados = new ArrayList<>(filmes.stream().filter(flm -> flm.getNomeDiretor().contains(diretor)).collect(Collectors.toList()));

        if(filmesEncontrados.isEmpty()){
            throw new FilmeInexistenteException();
        }
            return filmesEncontrados;
   }

   public List<Filmes> encontrarFilmeDataLancamento(final Date data) {
        List<Filmes> filmesEncontrados = new ArrayList<>(filmes.stream().filter(flm -> flm.getDataLancamento().equals(data)).collect(Collectors.toList()));

        if(filmesEncontrados.isEmpty()) {
            throw new FilmeInexistenteException();
        }
        return filmesEncontrados;
    }

    public Filmes cadastrarFilme(Filmes filmes) {

        if(filmes.getIdFilme() ==  null) {
            filmes.setIdFilme(count() + 1);
        }
        this.filmes.add(filmes);
        return null;
    }

    public void editarFilme(final Filmes filmes) {

        this.filmes.stream().filter(flm -> flm.getIdFilme().equals(filmes.getIdFilme()))
                            .forEach(flm -> flm.setNomeFilme(filmes.getNomeFilme()));

        this.filmes.stream().filter(flm -> flm.getIdFilme().equals(filmes.getIdFilme()))
                            .forEach(flm -> flm.setNomeDiretor(filmes.getNomeDiretor()));

        this.filmes.stream().filter(flm -> flm.getIdFilme().equals(filmes.getIdFilme()))
                            .forEach(flm -> flm.setDataLancamento(filmes.getDataLancamento()));

        this.filmes.stream().filter((flm -> flm.getIdFilme().equals(filmes.getIdFilme())))
                            .forEach(flm -> flm.setNotaFilme(filmes.getNotaFilme()));
    }

    public void deletarFilme(Integer id) {
        this.filmes.removeIf(flm -> flm.getIdFilme().equals(id));
    }

    public Integer count() {
        return filmes.size();
    }

}

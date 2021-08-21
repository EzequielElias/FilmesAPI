package br.com.edev.filmesapi.repositories;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.exceptions.FilmeInexistenteException;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;
import br.com.edev.filmesapi.exceptions.NotaInvalidaException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmesRepository {

    private final List<Filmes> filmesList;

    private FilmesRepository() {
        this.filmesList = new ArrayList<>();
    }

    public List<Filmes>  encontrarFilmes() {
        return filmesList;
    }

    public List<Filmes> encontrarFilmesNome(final String nome) {

        List<Filmes> filmesEncontrados = new ArrayList<>(filmesList.stream().filter(flm -> flm.getNome().contains(nome)).collect(Collectors.toList()));

        if(filmesEncontrados.isEmpty()) {
            throw new FilmeInexistenteException();
        }
        return filmesEncontrados;
    }

    public List<Filmes> encontrarFilmesDiretor(final String diretor) {

        List<Filmes> filmesEncontrados = new ArrayList<>(filmesList.stream().filter(flm -> flm.getDiretor().contains(diretor)).collect(Collectors.toList()));

        if(filmesEncontrados.isEmpty()){
            throw new FilmeInexistenteException();
        }
        return filmesEncontrados;
    }

    public Filmes cadastrarFilme(Filmes filmes){

        if(filmesList.stream().anyMatch(flm -> flm.getNome().equalsIgnoreCase(filmes.getNome())) &&
                filmesList.stream().anyMatch(flm1 -> flm1.getDiretor().equalsIgnoreCase(filmes.getDiretor())) &&
                    filmesList.stream().anyMatch(flm2 -> flm2.getAno().equalsIgnoreCase(filmes.getAno()))) {

                        throw new FilmeJaExistenteException();
        }
        if(filmes.getId() == null) {
            filmes.setId(filmesList.size() + 1);
        }
        if(filmes.getNota() < 1 || filmes.getNota() > 5) {
            throw new NotaInvalidaException();
        }

            this.filmesList.add(filmes);
            return filmes;
    }

    public void editarFilme(final Filmes filmes){

            filmesList.stream().filter(flm -> flm.getId().equals(filmes.getId()))
                    .forEach(flm -> flm.setNome(filmes.getNome()));

            filmesList.stream().filter(flm -> flm.getId().equals(filmes.getId()))
                    .forEach(flm -> flm.setDiretor(filmes.getDiretor()));

            filmesList.stream().filter(flm -> flm.getId().equals(filmes.getId()))
                    .forEach(flm -> flm.setAno(filmes.getAno()));

            filmesList.stream().filter((flm -> flm.getId().equals(filmes.getId())))
                    .forEach(flm -> flm.setNota(filmes.getNota()));
    }

    public void deletarFilme(Integer id) {
            filmesList.removeIf(filmes -> filmes.getId().equals(id));
        }
}
package br.com.edev.filmesapi.controllers;

import br.com.edev.filmesapi.entities.Filmes;
import br.com.edev.filmesapi.services.IFilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmesapi")
public class FilmesController {

    private final List<Filmes> filmesList;

    @Autowired
    private final IFilmesService filmesService;

    public FilmesController(IFilmesService filmesService) {
        this.filmesService = filmesService;
        this.filmesList = new ArrayList<>();
    }

    @GetMapping
    public List<Filmes> encontrarFilmes(@RequestParam(required = false) String nome, String diretor) {
        if(nome != null) {
            return filmesService.encontrarFilmesNome(nome);
        } else if (diretor != null) {
            return filmesService.encontrarFilmesDiretor(diretor);
        }
        return filmesService.encontrarFilmes();
        }

    @PostMapping
    public ResponseEntity<String> cadastrarFilme(@RequestBody final Filmes filmes) {
        filmesService.cadastrarFilme(filmes);
        final String criadoComSucesso = "Filme criado com sucesso!";
        return new ResponseEntity<String>(criadoComSucesso, HttpStatus.CREATED);
        }

    @PutMapping
    public ResponseEntity<String> editarFilme(@RequestBody final Filmes filmes) {
        filmesService.editarFilme(filmes);
        final String editadoComSucesso = "As informações do filme foram editadas com sucesso!";
        return new ResponseEntity<String>(editadoComSucesso, HttpStatus.OK);
        }

    @DeleteMapping("/deleteid={id}")
    public ResponseEntity<String> deletarFilme(@PathVariable("id") Integer id) {
        filmesService.deletarFilme(id);
        final String deletadoComSucesso = "O filme foi deletado com sucesso!";
        return new ResponseEntity<String>(deletadoComSucesso, HttpStatus.OK);
        }

}

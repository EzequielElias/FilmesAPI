package br.com.edev.filmesapi.controllers;

import br.com.edev.filmesapi.exceptions.FilmeInexistenteException;
import br.com.edev.filmesapi.exceptions.FilmeJaExistenteException;
import br.com.edev.filmesapi.exceptions.NotaInvalidaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    @ExceptionHandler({FilmeInexistenteException.class})
    public ResponseEntity<String> handle(final FilmeInexistenteException e) {
        final String filmeInexistente = "\n         -----        " +
                                        "\n Não foi encontrado nenhum filme com esse nome!" +
                                        "\n         -----        ";

        LOGGER.error(filmeInexistente);
        return new ResponseEntity<>(filmeInexistente, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({FilmeJaExistenteException.class})
    public ResponseEntity<String> handle(final FilmeJaExistenteException e) {
        final String filmeExistente = "\n       -----       " +
                                      "\n Você tentou criar um filme que ja existe" +
                                      "\n       -----       ";

        LOGGER.error(filmeExistente);
        return new ResponseEntity<>(filmeExistente, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({NotaInvalidaException.class})
    public ResponseEntity<String> handle(final NotaInvalidaException e) {
        final String notaInvalida = "\n       -----       " +
                                    "\n Você pode avaliar apenas com notas de 1 a 5" +
                                    "\n       -----       ";

        LOGGER.error(notaInvalida);
        return new ResponseEntity<>(notaInvalida, HttpStatus.CONFLICT);
    }
}

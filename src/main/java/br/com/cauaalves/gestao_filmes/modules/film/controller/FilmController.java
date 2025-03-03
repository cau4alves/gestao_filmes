package br.com.cauaalves.gestao_filmes.modules.film.controller;

import br.com.cauaalves.gestao_filmes.modules.film.model.FilmModel;
import br.com.cauaalves.gestao_filmes.modules.film.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping("/")
    private ResponseEntity<Object> create(@Valid @RequestBody FilmModel filmModel) {
        try {
            var result = this.filmService.execute(filmModel);
            return ResponseEntity.ok().body(result);
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

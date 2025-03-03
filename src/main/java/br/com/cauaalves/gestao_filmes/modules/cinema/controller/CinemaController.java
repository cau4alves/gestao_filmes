package br.com.cauaalves.gestao_filmes.modules.cinema.controller;

import br.com.cauaalves.gestao_filmes.modules.cinema.model.CinemaModel;
import br.com.cauaalves.gestao_filmes.modules.cinema.service.CinemaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CinemaModel cinemaModel) {
        try {
            var result = this.cinemaService.execute(cinemaModel);
            return ResponseEntity.ok().body(result);
        } catch(Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

package br.com.cauaalves.gestao_filmes.modules.film.repository;

import br.com.cauaalves.gestao_filmes.modules.film.model.FilmModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FilmRepository extends JpaRepository<FilmModel, Integer> {
    List<FilmModel> findByCinemaIdAndNroSala(UUID cinemaId, int nroSala);
}

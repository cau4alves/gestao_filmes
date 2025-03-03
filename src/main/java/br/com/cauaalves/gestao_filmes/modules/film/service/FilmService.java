package br.com.cauaalves.gestao_filmes.modules.film.service;

import br.com.cauaalves.gestao_filmes.Exceptions.SessionFound;
import br.com.cauaalves.gestao_filmes.modules.film.model.FilmModel;
import br.com.cauaalves.gestao_filmes.modules.film.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public FilmModel execute(FilmModel filmModel) {
        this.filmRepository.findByCinemaIdAndNroSalaAndHorario(filmModel.getCinemaId(), filmModel.getNroSala(), filmModel.getHorario())
                .ifPresent((user) -> {
                    throw new SessionFound();
                });
        ;

        return this.filmRepository.save(filmModel);
    }
}

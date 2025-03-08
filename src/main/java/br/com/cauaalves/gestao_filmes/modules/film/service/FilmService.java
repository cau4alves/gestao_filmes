package br.com.cauaalves.gestao_filmes.modules.film.service;

import br.com.cauaalves.gestao_filmes.exceptions.SessionFound;
import br.com.cauaalves.gestao_filmes.modules.film.model.FilmModel;
import br.com.cauaalves.gestao_filmes.modules.film.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public FilmModel execute(FilmModel filmModel) {
        // Obtém todas as sessões para o cinemaId e nroSala informados
        List<FilmModel> existingSessions = filmRepository.findByCinemaIdAndNroSala(
                filmModel.getCinemaId(), filmModel.getNroSala());

        // Calcula horário de término da nova sessão
        LocalTime startNew = filmModel.getStartSession();
        LocalTime endNew = getLocalTime(filmModel, startNew, existingSessions);

        // Define o horário de término da sessão antes de salvar
        filmModel.setEndSession(endNew);

        return filmRepository.save(filmModel);
    }

    private static LocalTime getLocalTime(FilmModel filmModel, LocalTime startNew, List<FilmModel> existingSessions) {
        LocalTime endNew = startNew.plusHours(filmModel.getDuration().getHour())
                .plusMinutes(filmModel.getDuration().getMinute());

        // Verifica se há alguma sessão que entra em conflito
        for (FilmModel session : existingSessions) {
            LocalTime startExisting = session.getStartSession();
            LocalTime endExisting = session.getEndSession();

            boolean isOverlapping = !(endNew.isBefore(startExisting) || startNew.isAfter(endExisting));

            if (isOverlapping) {
                throw new SessionFound(); // Exceção personalizada para indicar conflito de horário
            }
        }
        return endNew;
    }
}

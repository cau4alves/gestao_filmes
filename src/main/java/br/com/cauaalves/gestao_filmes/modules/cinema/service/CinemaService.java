package br.com.cauaalves.gestao_filmes.modules.cinema.service;

import br.com.cauaalves.gestao_filmes.Exceptions.UsernameFound;
import br.com.cauaalves.gestao_filmes.modules.cinema.model.CinemaModel;
import br.com.cauaalves.gestao_filmes.modules.cinema.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CinemaModel execute(CinemaModel cinemaModel) {
        this.cinemaRepository.findByUsername(cinemaModel.getUsername())
                .ifPresent((user) -> {
                    throw new UsernameFound();
                });

        var password = passwordEncoder.encode(cinemaModel.getPassword());
        cinemaModel.setPassword(password);

        return this.cinemaRepository.save(cinemaModel);
    }
}

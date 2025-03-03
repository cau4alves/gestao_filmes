package br.com.cauaalves.gestao_filmes.modules.cinema.repository;

import br.com.cauaalves.gestao_filmes.modules.cinema.model.CinemaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CinemaRepository extends JpaRepository<CinemaModel, UUID> {
    Optional<CinemaModel> findByUsername(String username);
}

package br.com.cauaalves.gestao_filmes.modules.film.model;

import br.com.cauaalves.gestao_filmes.modules.cinema.model.CinemaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity(name = "film")
public class FilmModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private LocalTime duration;

    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "cinema_id", insertable = false, updatable = false)
    private CinemaModel cinemaModel;

    @Column(name = "cinema_id")
    private UUID cinemaId;

    @Column(name = "nro_sala")
    private Integer nroSala;

    @Column(name = "start_session")
    private LocalTime startSession;

    @Column(name = "end_session")
    private LocalTime endSession;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

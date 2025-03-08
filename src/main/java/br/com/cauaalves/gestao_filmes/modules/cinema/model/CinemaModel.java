package br.com.cauaalves.gestao_filmes.modules.cinema.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity(name = "cinema")
public class CinemaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String endereco;

    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaços")
    private String username;

    @Length(min = 8, max = 100, message = "A senha deve conter entre 8 à 100 caracteres")
    private String password;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}

package ee.olaf.proovikontrolltoo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Filmi nimi ei tohi olla tühi.")
    private String nimi;

    @Enumerated(EnumType.STRING)
    private FilmType tyyp;

    private boolean rentida = true;
}
package ee.olaf.decathlon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Spordiala ei tohi olla tühi.")
    private String spordiala;

    @Positive(message = "Tulemus peab olema positiivne.")
    private double tulemus;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    private Athlete athlete;
}
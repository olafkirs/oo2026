package ee.olaf.soojushulgad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

// 2. ülesanne: eseme andmed (mass, temperatuur, viit ainele)
@Data
@Entity
public class Ese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // mass kg
    @Positive(message = "Mass peab olema positiivne.")
    private double mass;

    // temperatuur Celsiuse kraadides
    private double temperatuur;

    // viit ainele
    @ManyToOne
    private Aine aine;
}

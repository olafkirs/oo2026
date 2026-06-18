package ee.olaf.soojushulgad.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

// 1. ülesanne: aine omadused
@Data
@Entity
public class Aine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Aine nimetus ei tohi olla tühi.")
    private String nimetus;

    // erisoojus J/(kg*K)
    @Positive(message = "Erisoojus peab olema positiivne.")
    private double erisoojus;

    // erikaal (tihedus) kg/m^3
    @Positive(message = "Erikaal peab olema positiivne.")
    private double erikaal;
}

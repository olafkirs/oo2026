package ee.olaf.decathlon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nimi ei tohi olla tühi.")
    private String nimi;

    @NotBlank(message = "Riik ei tohi olla tühi.")
    private String riik;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<Result> tulemused;
}
package ee.olaf.decathlon.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nimi ei tohi olla tühi.")
    private String nimi;

    @NotBlank(message = "Riik ei tohi olla tühi.")
    private String riik;

    @JsonManagedReference
    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Result> tulemused = new ArrayList<>();
}
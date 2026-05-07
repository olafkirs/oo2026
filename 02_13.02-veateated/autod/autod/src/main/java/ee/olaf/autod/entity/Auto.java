package ee.olaf.autod.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Mark ei tohi olla tühi.")
    @Size(max = 50, message = "Mark võib olla kuni 50 tähemärki.")
    private String mark;

    @NotBlank(message = "Mudel ei tohi olla tühi.")
    @Size(max = 50, message = "Mudel võib olla kuni 50 tähemärki.")
    private String mudel;

    @Min(value = 1886, message = "Aasta peab olema vähemalt 1886.")
    @Max(value = 2100, message = "Aasta ei tohi olla suurem kui 2100.")
    private int aasta;

    @Positive(message = "Hind peab olema positiivne number.")
    private double hind;

    @PositiveOrZero(message = "Läbisõit ei tohi olla negatiivne.")
    private int labisoidu;
}
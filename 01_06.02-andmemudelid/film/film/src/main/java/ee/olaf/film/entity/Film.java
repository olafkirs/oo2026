package ee.olaf.film.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pealkiri;
    private String rezissoor;
    private int aasta;
    private String zanr;
}
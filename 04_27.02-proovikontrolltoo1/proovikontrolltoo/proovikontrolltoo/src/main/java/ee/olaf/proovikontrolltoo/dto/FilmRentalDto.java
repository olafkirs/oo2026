package ee.olaf.proovikontrolltoo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FilmRentalDto {
    private Long filmId;
    private LocalDate tagastamisTähtaeg;
}
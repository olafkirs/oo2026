package ee.olaf.proovikontrolltoo.dto;

import ee.olaf.proovikontrolltoo.entity.FilmType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FilmSaveDto {
    @NotBlank(message = "Filmi nimi ei tohi olla tühi.")
    private String nimi;
    private FilmType tyyp;
}
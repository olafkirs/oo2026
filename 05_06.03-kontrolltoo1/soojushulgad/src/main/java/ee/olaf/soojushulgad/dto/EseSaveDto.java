package ee.olaf.soojushulgad.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EseSaveDto {
    @Positive(message = "Mass peab olema positiivne.")
    private double mass;

    private double temperatuur;

    @NotNull(message = "Aine id on kohustuslik.")
    private Long aineId;
}

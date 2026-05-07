package ee.olaf.proovikontrolltoo.controller;

import ee.olaf.proovikontrolltoo.dto.FilmRentalDto;
import ee.olaf.proovikontrolltoo.entity.Rental;
import ee.olaf.proovikontrolltoo.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalController {

    private final FilmService filmService;

    @PostMapping
    public Rental rendiFilm(@RequestBody FilmRentalDto dto) {
        return filmService.rendiFilm(dto);
    }

    @PostMapping("/{id}/tagasta")
    public double tagastaFilm(@PathVariable Long id) {
        return filmService.tagastaFilm(id);
    }
}
package ee.olaf.proovikontrolltoo.controller;

import ee.olaf.proovikontrolltoo.dto.FilmSaveDto;
import ee.olaf.proovikontrolltoo.entity.Film;
import ee.olaf.proovikontrolltoo.entity.FilmType;
import ee.olaf.proovikontrolltoo.service.FilmService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/filmid")
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public List<Film> getFilmid() {
        return filmService.getFilmid();
    }

    @GetMapping("/vabad")
    public List<Film> getVabadFilmid() {
        return filmService.getVabadFilmid();
    }

    @PostMapping
    public Film lisaFilm(@Valid @RequestBody FilmSaveDto dto) {
        return filmService.lisaFilm(dto);
    }

    @DeleteMapping("/{id}")
    public void kustutaFilm(@PathVariable Long id) {
        filmService.kustutaFilm(id);
    }

    @PatchMapping("/{id}/tyyp")
    public Film muudaTyyp(@PathVariable Long id, @RequestParam FilmType tyyp) {
        return filmService.muudaTyyp(id, tyyp);
    }
}
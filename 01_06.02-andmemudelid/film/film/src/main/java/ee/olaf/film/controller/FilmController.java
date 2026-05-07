package ee.olaf.film.controller;

import ee.olaf.film.entity.Film;
import ee.olaf.film.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/filmid")
@RequiredArgsConstructor
public class FilmController {

    private final FilmRepository filmRepository;

    @GetMapping
    public List<Film> getFilmid() {
        return filmRepository.findAll();
    }

    @PostMapping
    public Film lisaFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    @DeleteMapping("/{id}")
    public void kustutaFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
    }
}
package ee.olaf.proovikontrolltoo.service;

import ee.olaf.proovikontrolltoo.dto.FilmRentalDto;
import ee.olaf.proovikontrolltoo.dto.FilmSaveDto;
import ee.olaf.proovikontrolltoo.entity.Film;
import ee.olaf.proovikontrolltoo.entity.FilmType;
import ee.olaf.proovikontrolltoo.entity.Rental;
import ee.olaf.proovikontrolltoo.repository.FilmRepository;
import ee.olaf.proovikontrolltoo.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final RentalRepository rentalRepository;

    // Lisa film
    public Film lisaFilm(FilmSaveDto dto) {
        Film film = new Film();
        film.setNimi(dto.getNimi());
        film.setTyyp(dto.getTyyp());
        return filmRepository.save(film);
    }

    // Kustuta film
    public void kustutaFilm(Long id) {
        filmRepository.deleteById(id);
    }

    // Muuda filmi tüüp
    public Film muudaTyyp(Long id, FilmType tyyp) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filmi ei leitud id-ga: " + id));
        film.setTyyp(tyyp);
        return filmRepository.save(film);
    }

    // Kõik filmid
    public List<Film> getFilmid() {
        return filmRepository.findAll();
    }

    // Filmid mis on poes (pole renditud)
    public List<Film> getVabadFilmid() {
        return filmRepository.findByRentidaTrue();
    }

    // Rendi film
    public Rental rendiFilm(FilmRentalDto dto) {
        Film film = filmRepository.findById(dto.getFilmId())
                .orElseThrow(() -> new RuntimeException("Filmi ei leitud!"));
        if (!film.isRentida()) {
            throw new RuntimeException("Film on juba renditud!");
        }
        film.setRentida(false);
        filmRepository.save(film);

        Rental rental = new Rental();
        rental.setFilm(film);
        rental.setRentimisKuupäev(LocalDate.now());
        rental.setTagastamisTähtaeg(dto.getTagastamisTähtaeg());
        return rentalRepository.save(rental);
    }

    // Tagasta film ja arvuta hind
    public double tagastaFilm(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rentimist ei leitud!"));

        Film film = rental.getFilm();
        film.setRentida(true);
        filmRepository.save(film);

        long päevi = ChronoUnit.DAYS.between(rental.getRentimisKuupäev(), LocalDate.now());
        long hilinemine = ChronoUnit.DAYS.between(rental.getTagastamisTähtaeg(), LocalDate.now());

        double hind = switch (film.getTyyp()) {
            case NEW_RELEASE -> päevi * 5.0;
            case REGULAR -> päevi * 3.0;
            case CHILDREN -> päevi * 1.5;
        };

        double hilinemine_tasu = hilinemine > 0 ? hilinemine * 2.0 : 0;
        return hind + hilinemine_tasu;
    }
}
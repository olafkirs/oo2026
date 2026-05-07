package ee.olaf.proovikontrolltoo.repository;

import ee.olaf.proovikontrolltoo.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByRentidaTrue();
}
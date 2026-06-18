package ee.olaf.soojushulgad.repository;

import ee.olaf.soojushulgad.entity.Ese;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EseRepository extends JpaRepository<Ese, Long> {
    // kõik esemed, mis on antud ainest
    List<Ese> findByAineId(Long aineId);
}

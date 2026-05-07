package ee.olaf.decathlon.repository;

import ee.olaf.decathlon.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    List<Athlete> findByRiik(String riik);
}
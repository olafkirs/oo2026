package ee.olaf.decathlon.repository;

import ee.olaf.decathlon.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    java.util.List<Result> findByAthleteId(Long athleteId);
}
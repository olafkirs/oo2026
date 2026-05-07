package ee.olaf.proovikontrolltoo.repository;

import ee.olaf.proovikontrolltoo.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
package ee.olaf.autod.service;

import ee.olaf.autod.entity.Auto;
import ee.olaf.autod.repository.AutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoService {

    private final AutoRepository autoRepository;

    public List<Auto> getAutod() {
        return autoRepository.findAll();
    }

    public Auto lisaAuto(Auto auto) {
        return autoRepository.save(auto);
    }
}
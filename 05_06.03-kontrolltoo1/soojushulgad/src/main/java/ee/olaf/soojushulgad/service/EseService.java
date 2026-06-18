package ee.olaf.soojushulgad.service;

import ee.olaf.soojushulgad.dto.EseSaveDto;
import ee.olaf.soojushulgad.entity.Aine;
import ee.olaf.soojushulgad.entity.Ese;
import ee.olaf.soojushulgad.repository.AineRepository;
import ee.olaf.soojushulgad.repository.EseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EseService {

    private final EseRepository eseRepository;
    private final AineRepository aineRepository;

    // lisa ese
    public Ese lisaEse(EseSaveDto dto) {
        Ese ese = new Ese();
        seoAndmed(ese, dto);
        return eseRepository.save(ese);
    }

    // muuda ese
    public Ese muudaEse(Long id, EseSaveDto dto) {
        Ese ese = eseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Eset ei leitud id-ga: " + id));
        seoAndmed(ese, dto);
        return eseRepository.save(ese);
    }

    // kustuta ese
    public void kustutaEse(Long id) {
        eseRepository.deleteById(id);
    }

    // kõik esemed
    public List<Ese> getEsemed() {
        return eseRepository.findAll();
    }

    // antud ainega esemete kogumass
    public double kogumass(Long aineId) {
        return eseRepository.findByAineId(aineId).stream()
                .mapToDouble(Ese::getMass)
                .sum();
    }

    private void seoAndmed(Ese ese, EseSaveDto dto) {
        Aine aine = aineRepository.findById(dto.getAineId())
                .orElseThrow(() -> new RuntimeException("Ainet ei leitud id-ga: " + dto.getAineId()));
        ese.setMass(dto.getMass());
        ese.setTemperatuur(dto.getTemperatuur());
        ese.setAine(aine);
    }
}

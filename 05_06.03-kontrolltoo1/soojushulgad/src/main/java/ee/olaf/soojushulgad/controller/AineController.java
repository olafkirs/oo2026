package ee.olaf.soojushulgad.controller;

import ee.olaf.soojushulgad.entity.Aine;
import ee.olaf.soojushulgad.repository.AineRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ained")
@RequiredArgsConstructor
public class AineController {

    private final AineRepository aineRepository;

    // sisesta uus aine
    @PostMapping
    public Aine lisaAine(@Valid @RequestBody Aine aine) {
        return aineRepository.save(aine);
    }

    // vaata kõiki aineid
    @GetMapping
    public List<Aine> getAined() {
        return aineRepository.findAll();
    }

    // kustuta aine
    @DeleteMapping("/{id}")
    public void kustutaAine(@PathVariable Long id) {
        aineRepository.deleteById(id);
    }
}

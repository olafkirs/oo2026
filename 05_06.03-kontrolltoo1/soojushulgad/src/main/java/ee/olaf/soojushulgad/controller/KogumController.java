package ee.olaf.soojushulgad.controller;

import ee.olaf.soojushulgad.entity.Ese;
import ee.olaf.soojushulgad.repository.EseRepository;
import ee.olaf.soojushulgad.service.Kogum;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kogum")
@RequiredArgsConstructor
public class KogumController {

    private final EseRepository eseRepository;

    // anna esemete id-d, tagasta ühtlustunud temperatuur
    @PostMapping("/temperatuur")
    public double yhtlustunudTemperatuur(@RequestBody List<Long> esemeIdd) {
        Kogum kogum = new Kogum();
        for (Long id : esemeIdd) {
            Ese ese = eseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Eset ei leitud id-ga: " + id));
            kogum.lisaEse(ese);
        }
        return kogum.ühtlustunudTemperatuur();
    }
}

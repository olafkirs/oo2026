package ee.olaf.decathlon.controller;

import ee.olaf.decathlon.entity.Athlete;
import ee.olaf.decathlon.entity.Result;
import ee.olaf.decathlon.service.DecathlonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sportlased")
@CrossOrigin(origins = "http://localhost:5173")
public class AthleteController {

    private final DecathlonService decathlonService;

    // Kõik sportlased
    @GetMapping
    public List<Athlete> getSportlased() {
        return decathlonService.getSportlased();
    }

    // Lisa sportlane
    @PostMapping
    public Athlete lisaSportlane(@Valid @RequestBody Athlete athlete) {
        return decathlonService.lisaSportlane(athlete);
    }

    // Lisa tulemus sportlasele
    @PostMapping("/{id}/tulemused")
    public Result lisaTulemus(@PathVariable Long id, @Valid @RequestBody Result result) {
        return decathlonService.lisaTulemus(id, result);
    }

    // Sportlase punktisumma
    @GetMapping("/{id}/punktisumma")
    public double getPunktisumma(@PathVariable Long id) {
        return decathlonService.getPunktisumma(id);
    }

    // Kustuta sportlane
    @DeleteMapping("/{id}")
    public void kustutaSportlane(@PathVariable Long id) {
        decathlonService.kustutaSportlane(id);
    }

    // Filtreeri riigi järgi
    @GetMapping("/filter")
    public List<Athlete> filterRiigi(@RequestParam String riik) {
        return decathlonService.filterRiigi(riik);
    }

    // Sorteeri punktisumma järgi
    @GetMapping("/sort")
    public List<Athlete> sortPunktisumma() {
        return decathlonService.sortPunktisumma();
    }
}
package ee.olaf.decathlon.service;

import ee.olaf.decathlon.entity.Athlete;
import ee.olaf.decathlon.entity.Result;
import ee.olaf.decathlon.repository.AthleteRepository;
import ee.olaf.decathlon.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DecathlonService {

    private final AthleteRepository athleteRepository;
    private final ResultRepository resultRepository;

    public Athlete lisaSportlane(Athlete athlete) {
        return athleteRepository.save(athlete);
    }

    public List<Athlete> getSportlased() {
        return athleteRepository.findAll();
    }

    public Result lisaTulemus(Long athleteId, Result result) {
        Athlete athlete = athleteRepository.findById(athleteId)
                .orElseThrow(() -> new RuntimeException("Sportlast ei leitud id-ga: " + athleteId));

        List<String> lubatudAlad = List.of("100m", "kaugushüpe");
        if (!lubatudAlad.contains(result.getSpordiala())) {
            throw new RuntimeException("Spordiala peab olema: " + lubatudAlad);
        }

        result.setAthlete(athlete);
        return resultRepository.save(result);
    }

    public double getPunktisumma(Long athleteId) {
        List<Result> tulemused = resultRepository.findByAthleteId(athleteId);
        return tulemused.stream()
                .mapToDouble(Result::getTulemus)
                .sum();
    }
}
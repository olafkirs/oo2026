package ee.olaf.soojushulgad.controller;

import ee.olaf.soojushulgad.dto.EseSaveDto;
import ee.olaf.soojushulgad.entity.Ese;
import ee.olaf.soojushulgad.service.EseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esemed")
@RequiredArgsConstructor
public class EseController {

    private final EseService eseService;

    @PostMapping
    public Ese lisaEse(@Valid @RequestBody EseSaveDto dto) {
        return eseService.lisaEse(dto);
    }

    @PutMapping("/{id}")
    public Ese muudaEse(@PathVariable Long id, @Valid @RequestBody EseSaveDto dto) {
        return eseService.muudaEse(id, dto);
    }

    @DeleteMapping("/{id}")
    public void kustutaEse(@PathVariable Long id) {
        eseService.kustutaEse(id);
    }

    @GetMapping
    public List<Ese> getEsemed() {
        return eseService.getEsemed();
    }

    // antud ainega esemete kogumass
    @GetMapping("/kogumass/{aineId}")
    public double kogumass(@PathVariable Long aineId) {
        return eseService.kogumass(aineId);
    }
}

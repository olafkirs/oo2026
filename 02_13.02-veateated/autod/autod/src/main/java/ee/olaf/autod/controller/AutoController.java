package ee.olaf.autod.controller;

import ee.olaf.autod.entity.Auto;
import ee.olaf.autod.service.AutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autod")
public class AutoController {

    private final AutoService autoService;

    @GetMapping
    public List<Auto> getAutod() {
        return autoService.getAutod();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Auto lisaAuto(@Valid @RequestBody Auto auto) {
        return autoService.lisaAuto(auto);
    }
}
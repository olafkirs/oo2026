package ee.olaf.paringud.controller;

import ee.olaf.paringud.entity.Asukoht;
import ee.olaf.paringud.entity.Kohtunik;
import ee.olaf.paringud.service.MockapiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mockapi")
public class MockapiController {

    private final MockapiService mockapiService;

    @GetMapping("/kohtunikud")
    public List<Kohtunik> getKohtunikud() {
        return mockapiService.getKohtunikud();
    }

    @GetMapping("/asukohad")
    public List<Asukoht> getAsukohad() {
        return mockapiService.getAsukohad();
    }
}
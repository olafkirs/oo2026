package ee.olaf.paringud.service;

import ee.olaf.paringud.entity.Asukoht;
import ee.olaf.paringud.entity.Kohtunik;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MockapiService {

    private final RestTemplate restTemplate;

    private static final String KOHTUNIKUD_URL = "https://69fd0b8630ad0a6fd1c07096.mockapi.io/api/v1/kohtunikud";
    private static final String ASUKOHAD_URL = "https://69fd0b8630ad0a6fd1c07096.mockapi.io/api/v1/asukohad";

    public List<Kohtunik> getKohtunikud() {
        Kohtunik[] kohtunikud = restTemplate.getForObject(KOHTUNIKUD_URL, Kohtunik[].class);
        return Arrays.asList(kohtunikud);
    }

    public List<Asukoht> getAsukohad() {
        Asukoht[] asukohad = restTemplate.getForObject(ASUKOHAD_URL, Asukoht[].class);
        return Arrays.asList(asukohad);
    }
}
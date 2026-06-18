package ee.olaf.soojushulgad;

import ee.olaf.soojushulgad.entity.Aine;
import ee.olaf.soojushulgad.entity.Ese;
import ee.olaf.soojushulgad.service.Kogum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SoojushulgadApplicationTests {

	@Test
	void contextLoads() {
	}

	private Aine vesi() {
		Aine vesi = new Aine();
		vesi.setNimetus("Vesi");
		vesi.setErisoojus(4186); // J/(kg*K)
		vesi.setErikaal(1000);
		return vesi;
	}

	private Ese ese(Aine aine, double mass, double temp) {
		Ese ese = new Ese();
		ese.setAine(aine);
		ese.setMass(mass);
		ese.setTemperatuur(temp);
		return ese;
	}

	@Test
	void kaheVordseVeekoguseKeskmine() {
		// 1 kg vett 20°C + 1 kg vett 80°C  ->  50°C
		Aine vesi = vesi();
		Kogum kogum = new Kogum();
		kogum.lisaEse(ese(vesi, 1, 20));
		kogum.lisaEse(ese(vesi, 1, 80));

		assertEquals(50.0, kogum.ühtlustunudTemperatuur(), 0.0001);
	}

	@Test
	void erinevadMassidKaaluvad() {
		// 3 kg vett 10°C + 1 kg vett 90°C  ->  (3*10 + 1*90)/4 = 30°C
		Aine vesi = vesi();
		Kogum kogum = new Kogum();
		kogum.lisaEse(ese(vesi, 3, 10));
		kogum.lisaEse(ese(vesi, 1, 90));

		assertEquals(30.0, kogum.ühtlustunudTemperatuur(), 0.0001);
	}

	@Test
	void erinevadAinedJaMassid() {
		// vesi (c=4186) 2 kg 20°C + raud (c=450) 1 kg 100°C
		Aine vesi = vesi();
		Aine raud = new Aine();
		raud.setNimetus("Raud");
		raud.setErisoojus(450);
		raud.setErikaal(7870);

		Kogum kogum = new Kogum();
		kogum.lisaEse(ese(vesi, 2, 20));
		kogum.lisaEse(ese(raud, 1, 100));

		// t = (4186*2*20 + 450*1*100) / (4186*2 + 450*1)
		double oodatud = (4186.0 * 2 * 20 + 450.0 * 1 * 100) / (4186.0 * 2 + 450.0 * 1);
		assertEquals(oodatud, kogum.ühtlustunudTemperatuur(), 0.0001);
	}

}

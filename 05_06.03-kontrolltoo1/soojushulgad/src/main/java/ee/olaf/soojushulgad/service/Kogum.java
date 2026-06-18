package ee.olaf.soojushulgad.service;

import ee.olaf.soojushulgad.entity.Ese;

import java.util.ArrayList;
import java.util.List;

// 3. ülesanne: esemete kogum, mille temperatuurid ühtlustuvad
public class Kogum {

    private final List<Ese> esemed = new ArrayList<>();

    public void lisaEse(Ese ese) {
        esemed.add(ese);
    }

    public void eemaldaEse(Ese ese) {
        esemed.remove(ese);
    }

    public List<Ese> getEsemed() {
        return esemed;
    }

    // temperatuur pärast ühtlustumist
    // t = summa(c*m*t) / summa(c*m)
    public double ühtlustunudTemperatuur() {
        if (esemed.isEmpty()) {
            throw new RuntimeException("Kogum on tühi.");
        }
        double lugeja = 0;   // summa c*m*t
        double nimetaja = 0; // summa c*m
        for (Ese ese : esemed) {
            double c = ese.getAine().getErisoojus();
            double m = ese.getMass();
            double t = ese.getTemperatuur();
            lugeja += c * m * t;
            nimetaja += c * m;
        }
        return lugeja / nimetaja;
    }
}

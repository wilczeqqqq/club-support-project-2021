package pl.dowhankuniewski;

import org.junit.jupiter.api.RepeatedTest;
import pl.dowhankuniewski.czlonkowie.ICzlonek;
import pl.dowhankuniewski.mapa.Mapa;
import pl.dowhankuniewski.stworzliste.StworzListeCzlonek;
import pl.dowhankuniewski.stworzliste.StworzListePole;

import static org.junit.jupiter.api.Assertions.*;

class SymulacjaTest {

    // UWAGA !!! Testy wymagają uprzedniej zmiany pól oraz metod na publiczne!
    // W przeciwnym wypadku testy nie zadziałają !!!
    // Zaleca się podejrzenie pliku z raportem wyników testów w /build/reports/index.html

    @RepeatedTest(10)
    void wykonajRuch() {
        Mapa mapa = new Mapa(100);
        StworzListeCzlonek stworzListeCzlonek = new StworzListeCzlonek(10);
        StworzListePole stworzListePole = new StworzListePole(10);
        Symulacja symulacja = new Symulacja(mapa,stworzListeCzlonek,stworzListePole,50,5);
        int posX = (symulacja.czlonkowieLista.get(1)).getPositionX();
        int posY = (symulacja.czlonkowieLista.get(1)).getPositionY();

        for (int i = 0; i < symulacja.maxIter; i++) {
            symulacja.wykonajRuch();
        }
        assertTrue((posX != (symulacja.czlonkowieLista.get(1)).getPositionX() || posY != (symulacja.czlonkowieLista.get(1)).getPositionY())
                && ((symulacja.czlonkowieLista.get(1)).getPositionX() <= mapa.getRozmiarMapy() && (symulacja.czlonkowieLista.get(1)).getPositionY() <= mapa.getRozmiarMapy()));
    }

    @RepeatedTest(10)
    void sprawdzSpotkanieCzlonkow() {
        Mapa mapa = new Mapa(3);
        StworzListeCzlonek stworzListeCzlonek = new StworzListeCzlonek(50);
        StworzListePole stworzListePole = new StworzListePole(0);
        Symulacja symulacja = new Symulacja(mapa,stworzListeCzlonek,stworzListePole,10,2);

        for (int i = 0; i < symulacja.maxIter; i++) {
            symulacja.sprawdzSpotkanieCzlonkow();
        }
        int checker=0;
        for (ICzlonek czlonek: symulacja.czlonkowieLista) {
            if (czlonek.getPoparcie().equals("KMP")) checker++;
        }
        assertTrue(checker != 10);
    }

    @RepeatedTest(10)
    void sprawdzWejscieNaPole() {
        Mapa mapa = new Mapa(3);
        StworzListeCzlonek stworzListeCzlonek = new StworzListeCzlonek(10);
        StworzListePole stworzListePole = new StworzListePole(10);
        Symulacja symulacja = new Symulacja(mapa,stworzListeCzlonek,stworzListePole,10,2);

        symulacja.sprawdzWejscieNaPole();

        int checker=0;
        for (ICzlonek czlonek: symulacja.czlonkowieLista) {
            if (czlonek.getCzyChroniony()) checker++;
        }
        assertTrue(checker != 0);
    }

    @RepeatedTest(10)
    void sprawdzCechySpecjalne() {
        Mapa mapa = new Mapa(100);
        StworzListeCzlonek stworzListeCzlonek = new StworzListeCzlonek(100);
        StworzListePole stworzListePole = new StworzListePole(1);
        Symulacja symulacja = new Symulacja(mapa,stworzListeCzlonek,stworzListePole,10,2);

        symulacja.sprawdzCechySpecjalne();

        int checker=0;
        for (ICzlonek czlonek: symulacja.czlonkowieLista) {
            if (czlonek.getPredkosc() != 2) checker++;
        }
        assertTrue(checker != 0);
    }
}
package pl.dowhankuniewski.stworzliste;

import org.junit.jupiter.api.Test;
import pl.dowhankuniewski.mapa.Mapa;

import static org.junit.jupiter.api.Assertions.*;

class StworzListeCzlonekTest {

    @Test
    void stworzListeCzlonkowie() {
        StworzListeCzlonek lista = new StworzListeCzlonek(10);
        Mapa mapa = new Mapa(10);
        assertNotNull(lista.stworzListeCzlonkowie(mapa, 10));
    }
}
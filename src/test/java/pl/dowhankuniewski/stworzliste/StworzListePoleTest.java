package pl.dowhankuniewski.stworzliste;

import org.junit.jupiter.api.Test;
import pl.dowhankuniewski.mapa.Mapa;

import static org.junit.jupiter.api.Assertions.*;

class StworzListePoleTest {

    @Test
    void stworzListePole() {
        StworzListePole lista = new StworzListePole(10);
        Mapa mapa = new Mapa(10);
        assertNotNull(lista.stworzListePole(mapa));
    }
}
package pl.dowhankuniewski.mapa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaTest {

    @Test
    void getRozmiarMapy() {
        Mapa mapa = new Mapa(10);
        assertEquals(10,mapa.getRozmiarMapy());
    }
}
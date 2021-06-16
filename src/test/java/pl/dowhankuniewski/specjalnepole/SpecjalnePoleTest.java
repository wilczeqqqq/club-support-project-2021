package pl.dowhankuniewski.specjalnepole;

import org.junit.jupiter.api.Test;
import pl.dowhankuniewski.mapa.Mapa;

import static org.junit.jupiter.api.Assertions.*;

class SpecjalnePoleTest {

    @Test
    void getPositionX() {
        Mapa mapa = new Mapa(10);
        SpecjalnePole pole = new SpecjalnePole(mapa);
        assertTrue(pole.getPositionX() <= mapa.getRozmiarMapy() && pole.getPositionX() >= 0);
    }

    @Test
    void getPositionY() {
        Mapa mapa = new Mapa(10);
        SpecjalnePole pole = new SpecjalnePole(mapa);
        assertTrue(pole.getPositionY() <= mapa.getRozmiarMapy() && pole.getPositionY() >= 0);
    }
}
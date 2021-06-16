package pl.dowhankuniewski.czlonkowie;

import org.junit.jupiter.api.Test;
import pl.dowhankuniewski.mapa.Mapa;

import static org.junit.jupiter.api.Assertions.*;

class ACzlonekTest {

    @Test
    void getPoparcie() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        assertEquals("KMP",czlonek.getPoparcie());
    }

    @Test
    void setPoparcie() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        czlonek.setPoparcie("KMW");
        assertEquals("KMW", czlonek.getPoparcie());
    }

    @Test
    void getCzyChroniony() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        assertFalse(czlonek.getCzyChroniony());
    }

    @Test
    void setCzyChroniony() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        czlonek.setCzyChroniony(true);
        assertTrue(czlonek.getCzyChroniony());
    }

    @Test
    void getPositionX() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        assertTrue(czlonek.getPositionX() <= mapa.getRozmiarMapy() && czlonek.getPositionX() >= 0);
    }

    @Test
    void setPositionX() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        czlonek.setPositionX(20);
        assertFalse(czlonek.getPositionX() <= mapa.getRozmiarMapy() && czlonek.getPositionX() >= 0);
    }

    @Test
    void getPositionY() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        assertTrue(czlonek.getPositionY() <= mapa.getRozmiarMapy() && czlonek.getPositionY() >= 0);
    }

    @Test
    void setPositionY() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        czlonek.setPositionY(20);
        assertFalse(czlonek.getPositionY() <= mapa.getRozmiarMapy() && czlonek.getPositionY() >= 0);
    }

    @Test
    void getPredkosc() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        assertEquals(2, czlonek.getPredkosc());
    }

    @Test
    void setPredkosc() {
        Mapa mapa = new Mapa(10);
        KMPCzlonek czlonek = new KMPCzlonek("KMP",mapa, 2);
        czlonek.setPredkosc(20);
        assertEquals(20, czlonek.getPredkosc());
    }
}
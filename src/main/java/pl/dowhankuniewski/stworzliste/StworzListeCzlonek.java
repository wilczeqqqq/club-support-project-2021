package pl.dowhankuniewski.stworzliste;

import pl.dowhankuniewski.czlonkowie.ICzlonek;
import pl.dowhankuniewski.czlonkowie.KMPCzlonek;
import pl.dowhankuniewski.czlonkowie.KMWCzlonek;
import pl.dowhankuniewski.mapa.Mapa;

import java.util.LinkedList;
import java.util.List;

public class StworzListeCzlonek {
    private final int iloscCzlonkow;

    public StworzListeCzlonek(int iloscCzlonkow) {
        this.iloscCzlonkow = iloscCzlonkow;
    }

    public List<ICzlonek> stworzListeCzlonkowie (Mapa mapa, int predkosc) {
        List<ICzlonek> lista = new LinkedList<>();

        for (int i=0; i<iloscCzlonkow; i++) {
            lista.add(new KMPCzlonek("KMP", mapa, predkosc));
            lista.add(new KMWCzlonek("KMW", mapa, predkosc));
        }

        return lista;
    }
}

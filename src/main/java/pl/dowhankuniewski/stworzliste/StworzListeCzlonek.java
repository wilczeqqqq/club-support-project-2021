package pl.dowhankuniewski.stworzliste;

import pl.dowhankuniewski.czlonkowie.ICzlonek;
import pl.dowhankuniewski.czlonkowie.KMPCzlonek;
import pl.dowhankuniewski.czlonkowie.KMWCzlonek;
import pl.dowhankuniewski.mapa.Mapa;

import java.util.LinkedList;
import java.util.List;

/**
 * Klasa 'StworzListeCzlonek' odpowiedzialna za utworzenie list obiektów członków klubów.
 */
public class StworzListeCzlonek {
    /** Ilość członków danego klubu. */
    private final int iloscCzlonkow;

    /**
     * Konstruktor obiektu 'StworzListeCzlonek'.
     * @param iloscCzlonkow Ilość członków danego klubu.
     * @see StworzListeCzlonek
     */
    public StworzListeCzlonek(int iloscCzlonkow) {
        this.iloscCzlonkow = iloscCzlonkow;
    }

    /**
     * Metoda 'stworzListeCzlonkowie()' odpowiedzialna za stworzenie listy członków dwóch klubów.
     * @param mapa Mapa, na której rozgrywa się symulacja.
     * @param predkosc Prędkość poruszania się klubowiczów.
     * @return Lista obiektów członków dwóch klubów.
     */
    public List<ICzlonek> stworzListeCzlonkowie (Mapa mapa, int predkosc) {
        List<ICzlonek> lista = new LinkedList<>();

        for (int i=0; i<iloscCzlonkow; i++) {
            lista.add(new KMPCzlonek("KMP", mapa, predkosc));
            lista.add(new KMWCzlonek("KMW", mapa, predkosc));
        }

        return lista;
    }
}

package pl.dowhankuniewski.stworzliste;

import pl.dowhankuniewski.mapa.Mapa;
import pl.dowhankuniewski.specjalnepole.ISpecjalnePole;
import pl.dowhankuniewski.specjalnepole.SpecjalnePole;

import java.util.LinkedList;
import java.util.List;

/**
 * Klasa 'StworzListePole' odpowiedzialna za utworzenie list obiektów pól specjalnych.
 */
public class StworzListePole {
    /** Ilość pól specjalnych. */
    private final int iloscPol;

    /**
     * Konstruktor obiektu 'StworzListePole'.
     * @param iloscPol Ilość pól specjalnych.
     * @see StworzListePole
     */
    public StworzListePole(int iloscPol) {
        this.iloscPol = iloscPol;
    }

    /**
     * Metoda 'stworzListePole()' odpowiedzialna za stworzenie listy pól specjalnych.
     * @param mapa Mapa, na której rozgrywa się symulacja.
     * @return Listy obiektów pól specjalnych.
     */
    public List<ISpecjalnePole> stworzListePole(Mapa mapa) {
        List<ISpecjalnePole> lista = new LinkedList<>();

        for (int i=0; i<iloscPol; i++) {
            lista.add(new SpecjalnePole(mapa));
        }

        return lista;
    }
}

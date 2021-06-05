package pl.dowhankuniewski.czlonkowie;

import pl.dowhankuniewski.mapa.Mapa;

/**
 * Klasa 'KMWCzlonek' reprezentująca członków Klubu Miłośników Wina w symulacji.
 * Rozszerza klasę abstrakcyjną 'ACzlonek'.
 */
public class KMWCzlonek extends ACzlonek {
    /** Cecha specjalna dla członków KMW. */
    private final boolean czyPilWino;

    /**
     * Konstruktor obiektu 'KMWCzlonek'.
     * @see ACzlonek#ACzlonek(String, Mapa, int)
     */
    public KMWCzlonek(String poparcie, Mapa mapa, int predkosc) {

        super(poparcie, mapa, predkosc);
        this.czyPilWino = ((int)(Math.random() * 99 + 1)) < 67;
    }

    @Override
    public boolean getCechaSpecjalna() {
        return czyPilWino;
    }
}

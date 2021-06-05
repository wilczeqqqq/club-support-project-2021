package pl.dowhankuniewski.czlonkowie;

import pl.dowhankuniewski.mapa.Mapa;

/**
 * Klasa 'KMPCzlonek' reprezentująca członków Klubu Miłośników Piwa w symulacji.
 * Rozszerza klasę abstrakcyjną 'ACzlonek'.
 */
public class KMPCzlonek extends ACzlonek {
    /** Cecha specjalna dla członków KMP. */
    private final boolean czyMaPiwnyBrzuch;

    /**
     * Konstruktor obiektu 'KMPCzlonek'.
     * @see ACzlonek#ACzlonek(String, Mapa, int)
     */
    public KMPCzlonek(String poparcie, Mapa mapa, int predkosc) {

        super(poparcie, mapa, predkosc);
        this.czyMaPiwnyBrzuch = ((int)(Math.random() * 99 + 1)) < 34;
    }

    @Override
    public boolean getCechaSpecjalna() {
        return czyMaPiwnyBrzuch;
    }
}

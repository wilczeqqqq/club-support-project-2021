package pl.dowhankuniewski.czlonkowie;

import pl.dowhankuniewski.mapa.Mapa;

public class KMPCzlonek extends ACzlonek {
    private final boolean czyMaPiwnyBrzuch;

    public KMPCzlonek(String poparcie, Mapa mapa, int predkosc) {

        super(poparcie, mapa, predkosc);
        this.czyMaPiwnyBrzuch = ((int)(Math.random() * 99 + 1)) < 34;
    }

    @Override
    public boolean getCechaSpecjalna() {
        return czyMaPiwnyBrzuch;
    }
}

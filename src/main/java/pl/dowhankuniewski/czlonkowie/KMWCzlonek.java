package pl.dowhankuniewski.czlonkowie;

import pl.dowhankuniewski.mapa.Mapa;

public class KMWCzlonek extends ACzlonek {
    private final boolean czyPilWino;

    public KMWCzlonek(String poparcie, Mapa mapa, int predkosc) {

        super(poparcie, mapa, predkosc);
        this.czyPilWino = ((int)(Math.random() * 99 + 1)) < 67;
    }

    @Override
    public boolean getCechaSpecjalna() {
        return czyPilWino;
    }
}

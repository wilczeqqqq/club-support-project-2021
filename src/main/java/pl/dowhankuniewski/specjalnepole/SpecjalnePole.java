package pl.dowhankuniewski.specjalnepole;

import pl.dowhankuniewski.mapa.Mapa;

/**
 * Klasa 'SpecjalnePole' reprezentująca pole specjalne w symulacji.
 * Implementuje interfejs 'ISpecjalnePole'.
 */
public class SpecjalnePole implements ISpecjalnePole {
    /** Pozycja X pola specjalnego. */
    private final int positionX;
    /** Pozycja Y pola specjalnego. */
    private final int positionY;

    /**
     * Konstruktor obiektu 'SpecjalnePole'.
     * @param mapa Mapa, na której odbywa się symulacja.
     * @see SpecjalnePole
     */
    public SpecjalnePole(Mapa mapa) {
        this.positionX = (int)(Math.random()* mapa.getRozmiarMapy());
        this.positionY = (int)(Math.random()* mapa.getRozmiarMapy());
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }
}

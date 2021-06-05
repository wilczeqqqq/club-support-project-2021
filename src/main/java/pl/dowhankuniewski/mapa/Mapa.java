package pl.dowhankuniewski.mapa;

/**
 * Klasa 'Mapa' reprezentująca mapę, na której przeprowadzana jest symulacja.
 * Implementuje interfejs 'IMapa'.
 */
public class Mapa implements IMapa {
    /** Rozmiar boku kwadratowej mapy, na której odbywa się symulacja. */
    private final int rozmiarMapy;

    /**
     * Konstruktor obiektu 'Mapa'.
     * @param rozmiarMapy Rozmiar boku kwadratowej mapy.
     * @see Mapa
     */
    public Mapa(int rozmiarMapy) {
        this.rozmiarMapy = rozmiarMapy;
    }

    @Override
    public int getRozmiarMapy() {

        return rozmiarMapy;
    }
}


package pl.dowhankuniewski.mapa;

public class Mapa implements IMapa {
    private int rozmiarMapy;

    public Mapa(int rozmiarMapy) {
        this.rozmiarMapy = rozmiarMapy;
    }

    @Override
    public int getRozmiarMapy() {

        return rozmiarMapy;
    }
}


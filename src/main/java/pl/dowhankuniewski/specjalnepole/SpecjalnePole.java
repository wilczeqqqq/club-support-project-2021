package pl.dowhankuniewski.specjalnepole;

import pl.dowhankuniewski.mapa.Mapa;

public class SpecjalnePole implements ISpecjalnePole {
    private int positionX;
    private int positionY;

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

package pl.dowhankuniewski.czlonkowie;

import pl.dowhankuniewski.mapa.Mapa;

public abstract class ACzlonek implements ICzlonek {
    protected String poparcie;
    protected boolean czyChroniony = false;
    protected int positionX;
    protected int positionY;
    protected int predkosc;

    public ACzlonek(String poparcie, Mapa mapa, int predkosc) {
        this.poparcie = poparcie;
        this.positionX = (int)(Math.random()* mapa.getRozmiarMapy());
        this.positionY = (int)(Math.random()* mapa.getRozmiarMapy());
        this.predkosc = predkosc;
    }


    @Override
    public String getPoparcie() {
        return poparcie;
    }

    @Override
    public void setPoparcie(String poparcie) {
        this.poparcie = poparcie;
    }

    @Override
    public boolean getCzyChroniony() {
        return czyChroniony;
    }

    @Override
    public void setCzyChroniony(boolean czyChroniony) {
        this.czyChroniony = czyChroniony;
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public int getPredkosc() {
        return predkosc;
    }

    @Override
    public void setPredkosc(int predkosc) {
        this.predkosc = predkosc;
    }
}

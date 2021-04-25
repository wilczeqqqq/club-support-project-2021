package pl.dowhankuniewski.czlonkowie;

public abstract class ACzlonek implements ICzlonek {
    public String poparcie;
    public boolean czyChroniony = false;
    public int positionX;
    public int positionY;

    public ACzlonek(String poparcie, int rozmiarMapy) {
        this.poparcie = poparcie;
        this.positionX = (int)(Math.random()*rozmiarMapy+0);
        this.positionY = (int)(Math.random()*rozmiarMapy+0);
    }

    @Override
    public void dajOchrone() {
        czyChroniony = true;
    }
}

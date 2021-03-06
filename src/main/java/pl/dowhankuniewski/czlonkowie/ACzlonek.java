package pl.dowhankuniewski.czlonkowie;

import pl.dowhankuniewski.mapa.Mapa;

/**
 * Klasa abstrakcyjna 'ACzlonek' zawierająca pola oraz implementacje metod wspólnych dla członków klubów.
 * Implementuje interfejs 'ICzlonek'
 */
public abstract class ACzlonek implements ICzlonek {
    /** Pogląd klubowicza. */
    protected String poparcie;
    /** Status ochrony klubowicza. */
    protected boolean czyChroniony = false;
    /** Pozycja X klubowicza. */
    protected int positionX;
    /** Pozycja Y klubowicza. */
    protected int positionY;
    /** Prędkość poruszania się klubowicza. */
    protected int predkosc;

    /**
     * Konstruktor dla klas rozszerzających klasę 'ACzlonek'.
     * @param poparcie Pogląd klubowicza.
     * @param mapa Mapa, na której rozgrywana jest symulacja.
     * @param predkosc Prędkość poruszania się klubowicza.
     * @see ACzlonek
     */
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

package pl.dowhankuniewski.czlonkowie;

public interface ICzlonek {

    String getPoparcie();

    void setPoparcie(String poparcie);

    boolean getCzyChroniony();

    void setCzyChroniony(boolean czyChroniony);

    int getPositionX();

    void setPositionX(int positionX);

    int getPositionY();

    void setPositionY(int positionY);

    int getPredkosc();

    void setPredkosc(int predkosc);
}

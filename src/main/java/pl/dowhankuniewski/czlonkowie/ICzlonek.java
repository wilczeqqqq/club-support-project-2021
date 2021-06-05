package pl.dowhankuniewski.czlonkowie;

/**
 * Interfejs 'ICzlonek' zawierający podstawowe metody dla członków klubów, stanowiących podstawę symulacji.
 */
public interface ICzlonek {

    /**
     * Metoda 'getPoparcie()' stanowiąca getter.
     * @return Wartość tekstowa poparcia klubowicza.
     */
    String getPoparcie();

    /**
     * Metoda 'setPoparcie()' stanowiąca setter.
     * @param poparcie Wartość tekstowa poparcia klubowicza.
     */
    void setPoparcie(String poparcie);

    /**
     * Metoda 'getCzyChroniony()' stanowiąca getter.
     * @return Wartość true/false ochrony poglądów.
     */
    boolean getCzyChroniony();

    /**
     * Metoda 'setCzyChroniony()' stanowiąca setter.
     * @param czyChroniony Wartość true/false ochrony poglądów.
     */
    void setCzyChroniony(boolean czyChroniony);

    /**
     * Metoda 'getPositionX()' stanowiąca getter.
     * @return Pozycja X klubowicza.
     */
    int getPositionX();

    /**
     * Metoda 'setPositionX()' stanowiąca setter.
     * @param positionX Pozycja X klubowicza.
     */
    void setPositionX(int positionX);

    /**
     * Metoda 'getPositionY()' stanowiąca getter.
     * @return Pozycja Y klubowicza.
     */
    int getPositionY();

    /**
     * Metoda 'setPositionY()' stanowiąca setter.
     * @param positionY Pozycja Y klubowicza.
     */
    void setPositionY(int positionY);

    /**
     * Metoda 'getPredkosc()' stanowiąca getter.
     * @return Wartość prędkości poruszania się klubowiczów.
     */
    int getPredkosc();

    /**
     * Metoda 'getCechaSpecjalna()' stanowiąca getter.
     * @return Wartość true/false posiadania cechy specjalnej.
     */
    boolean getCechaSpecjalna();

    /**
     * Metoda 'setPositionY()' stanowiąca setter.
     * @param predkosc Wartość prędkości poruszania się klubowiczów.
     */
    void setPredkosc(int predkosc);
}

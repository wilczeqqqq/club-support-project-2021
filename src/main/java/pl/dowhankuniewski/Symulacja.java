package pl.dowhankuniewski;

import pl.dowhankuniewski.czlonkowie.ICzlonek;
import pl.dowhankuniewski.mapa.Mapa;
import pl.dowhankuniewski.specjalnepole.ISpecjalnePole;
import pl.dowhankuniewski.stworzliste.StworzListeCzlonek;
import pl.dowhankuniewski.stworzliste.StworzListePole;

import java.util.List;
import java.util.Scanner;


public class Symulacja {
    Mapa mapa;
    List<ICzlonek> czlonkowieLista;
    List<ISpecjalnePole> specjalnePoleLista;
    int maxIter;

    public Symulacja(Mapa mapa, StworzListeCzlonek stworzListeCzlonek, StworzListePole stworzListePole, int maxIter, int predkosc) {
        this.mapa = mapa;
        czlonkowieLista = stworzListeCzlonek.stworzListeCzlonkowie(mapa, predkosc);
        specjalnePoleLista = stworzListePole.stworzListePole(mapa);
        this.maxIter = maxIter;
    }

    public void wykonajRuch() {
        for (ICzlonek czlonek : czlonkowieLista) {

            if (((int)(Math.random()*99+1)) > 50) {
                czlonek.setPositionX(czlonek.getPositionX() + czlonek.getPredkosc());
            }

            if (((int)(Math.random()*99+1)) > 50) {
                czlonek.setPositionX(czlonek.getPositionX() - czlonek.getPredkosc());
            }

            if (((int)(Math.random()*99+1)) > 50) {
                czlonek.setPositionY(czlonek.getPositionY() + czlonek.getPredkosc());
            }

            if (((int)(Math.random()*99+1)) > 50) {
                czlonek.setPositionY(czlonek.getPositionY() - czlonek.getPredkosc());
            }
        }
    }

    public void sprawdzSpotkanieCzlonkow() {
        for (ICzlonek czlonek : czlonkowieLista) {
            for (ICzlonek czlonek2 : czlonkowieLista) {
                if (czlonek.getPositionX() == czlonek2.getPositionX() && czlonek.getPositionY() == czlonek2.getPositionY() && !czlonek.getPoparcie().equals(czlonek2.getPoparcie())) {
                    if (!czlonek.getCzyChroniony()) {
                        if (czlonek.getPoparcie().equals("KMP")) {
                            if (((int)(Math.random()*99+1)) > 50) {
                                czlonek.setPoparcie("KMW");
                            }
                        } else {
                            if (((int)(Math.random()*99+1)) > 50) {
                                czlonek.setPoparcie("KMP");
                            }
                        }
                    }

                    if (!czlonek2.getCzyChroniony()) {
                        if (czlonek2.getPoparcie().equals("KMP")) {
                            if (((int)(Math.random()*99+1)) > 50) {
                                czlonek2.setPoparcie("KMW");
                            }
                        } else {
                            if (((int)(Math.random()*99+1)) > 50) {
                                czlonek2.setPoparcie("KMP");
                            }
                        }
                    }
                }
            }
        }
    } //WIP (do zrobienia prawdopodobieństwo)

    public void sprawdzWejscieNaPole() {
        for (ICzlonek czlonek : czlonkowieLista) {
            for (ISpecjalnePole pole : specjalnePoleLista) {
                if (czlonek.getPositionX() == pole.getPositionX() && czlonek.getPositionY() == pole.getPositionY()) {
                    czlonek.setCzyChroniony(true);
                }
            }
        }
    }

    public void startSymulacji(){
        for(int iter=0; iter<maxIter; iter++) {
            wykonajRuch();
            sprawdzWejscieNaPole();
            sprawdzSpotkanieCzlonkow();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj rozmiar mapy nie mniejszy niz 100");
        int rozmiarMapy;
        for (;;) {
            rozmiarMapy = scanner.nextInt();
            if (rozmiarMapy < 100) {
                System.out.println("Podano zly wymiar. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj ilosc czlonkow w klubach nie wieksza niz " + (rozmiarMapy*rozmiarMapy)/2);
        int iloscCzlonkow;
        for (;;) {
            iloscCzlonkow = scanner.nextInt();
            if (iloscCzlonkow > (rozmiarMapy*rozmiarMapy)/2) {
                System.out.println("Podano za duza ilosc czlonkow. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj predkosc poruszania sie czlonkow klubow po mapie nie mniejsza niz 1");
        int predkosc;
        for (;;) {
            predkosc = scanner.nextInt();
            if (predkosc < 1) {
                System.out.println("Podano za mala predkosc. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj ilosc pol specjalnych na mapie");
        int iloscPol;
        for (;;) {
            iloscPol = scanner.nextInt();
            if (iloscPol < 0) {
                System.out.println("Podano niedozwolona ilosc. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj ilosc iteracji symulacji nie mniejsza niz 1");
        int iloscIteracji;
        for (;;) {
            iloscIteracji = scanner.nextInt();
            if (iloscIteracji < 1) {
                System.out.println("Podano niedozwolona ilosc. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }


        Mapa mapa = new Mapa(rozmiarMapy);
        StworzListePole stworzListePole = new StworzListePole(iloscPol);
        StworzListeCzlonek stworzListeCzlonek = new StworzListeCzlonek(iloscCzlonkow);

        Symulacja symulacja = new Symulacja(mapa, stworzListeCzlonek, stworzListePole, iloscIteracji, predkosc);

        symulacja.startSymulacji();

        System.out.println("END");
    }
}

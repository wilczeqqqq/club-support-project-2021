package pl.dowhankuniewski;

import pl.dowhankuniewski.czlonkowie.ICzlonek;
import pl.dowhankuniewski.mapa.Mapa;
import pl.dowhankuniewski.specjalnepole.ISpecjalnePole;
import pl.dowhankuniewski.stworzliste.StworzListeCzlonek;
import pl.dowhankuniewski.stworzliste.StworzListePole;

import java.io.FileNotFoundException;
import java.io.PrintStream;
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
            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionX(czlonek.getPositionX() + czlonek.getPredkosc());
                if (czlonek.getPositionX() > mapa.getRozmiarMapy()) {
                    czlonek.setPositionX(czlonek.getPositionX() - czlonek.getPredkosc());
                }
            }

            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionX(czlonek.getPositionX() - czlonek.getPredkosc());
                if (czlonek.getPositionX() > mapa.getRozmiarMapy()) {
                    czlonek.setPositionX(czlonek.getPositionX() + czlonek.getPredkosc());
                }
            }

            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionY(czlonek.getPositionY() + czlonek.getPredkosc());
                if (czlonek.getPositionY() > mapa.getRozmiarMapy()) {
                    czlonek.setPositionY(czlonek.getPositionX() - czlonek.getPredkosc());
                }
            }

            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionY(czlonek.getPositionY() - czlonek.getPredkosc());
                if (czlonek.getPositionY() > mapa.getRozmiarMapy()) {
                    czlonek.setPositionY(czlonek.getPositionX() + czlonek.getPredkosc());
                }
            }
        }
    }

    public void sprawdzSpotkanieCzlonkow() {
        int KMP=0, KMW=0;
        for (ICzlonek czlonekLicznik : czlonkowieLista) {
            if (czlonekLicznik.getPoparcie().equals("KMP")) {
                KMP++;
            } else {
                KMW++;
            }
        }

        for (ICzlonek czlonek : czlonkowieLista) {
            for (ICzlonek czlonek2 : czlonkowieLista) {
                if (czlonek.getPositionX() == czlonek2.getPositionX() && czlonek.getPositionY() == czlonek2.getPositionY() && !czlonek.getPoparcie().equals(czlonek2.getPoparcie())) {
                    if (!czlonek.getCzyChroniony()) {
                        if (czlonek.getPoparcie().equals("KMP")) {
                            if (((int)(Math.random()*99+1)) <= (KMW*100/czlonkowieLista.size())) {
                                czlonek.setPoparcie("KMW");
                            }
                        } else {
                            if (((int)(Math.random()*99+1)) <= (KMP*100/czlonkowieLista.size())) {
                                czlonek.setPoparcie("KMP");
                            }
                        }
                    }

                    if (!czlonek2.getCzyChroniony()) {
                        if (czlonek2.getPoparcie().equals("KMP")) {
                            if (((int)(Math.random()*99+1)) <= (KMW*100/czlonkowieLista.size())) {
                                czlonek2.setPoparcie("KMW");
                            }
                        } else {
                            if (((int)(Math.random()*99+1)) <= (KMP*100/czlonkowieLista.size())) {
                                czlonek2.setPoparcie("KMP");
                            }
                        }
                    }
                }
            }
        }
    }

    public void sprawdzWejscieNaPole() {
        for (ICzlonek czlonek : czlonkowieLista) {
            for (ISpecjalnePole pole : specjalnePoleLista) {
                if (czlonek.getPositionX() == pole.getPositionX() && czlonek.getPositionY() == pole.getPositionY()) {
                    czlonek.setCzyChroniony(true);
                }
            }
        }
    }

    public void zapisLogowDoPliku() {
        int KMP=0, KMW=0, chronieniKMP=0, chronieniKMW=0, suma;
        for (ICzlonek czlonek : czlonkowieLista) {
            if (czlonek.getPoparcie().equals("KMP")) {
                KMP++;
            } else {
                KMW++;
            }

            if (czlonek.getCzyChroniony() && czlonek.getPoparcie().equals("KMP")) {
                chronieniKMP++;
            }

            if (czlonek.getCzyChroniony() && czlonek.getPoparcie().equals("KMW")) {
                chronieniKMW++;
            }
        }

        suma = chronieniKMP + chronieniKMW;

        System.out.println("KMP/Chronieni:" + KMP + "/" + chronieniKMP + " - - - KMW/Chronieni:" + KMW + "/" + chronieniKMW + " - - - Chronieni - suma:" + suma);
    }

    public void startSymulacji(){
        for(int iter=0; iter<maxIter; iter++) {
            wykonajRuch();
            sprawdzWejscieNaPole();
            sprawdzSpotkanieCzlonkow();
            zapisLogowDoPliku();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj rozmiar mapy nie wiekszy niz 100");
        int rozmiarMapy;
        for (;;) {
            rozmiarMapy = scanner.nextInt();
            if (rozmiarMapy > 100) {
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

        PrintStream plik = new PrintStream("./outFile.txt");
        System.setOut(plik);

        symulacja.startSymulacji();

        System.out.println("END");
    }
}

package pl.dowhankuniewski;

import pl.dowhankuniewski.czlonkowie.KMPCzlonek;
import pl.dowhankuniewski.czlonkowie.KMWCzlonek;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Symulacja {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj ilość członków klubów: ");
        int iloscCzlonkow = scan.nextInt();

        System.out.println("Podaj wielkość kwadratowej mapy: ");
        int rozmiarMapy = scan.nextInt();

        List<KMPCzlonek> KMPCzlonekLista = new ArrayList<>();
        List<KMWCzlonek> KMWCzlonekLista = new ArrayList<>();

        for(int i = 0; i < iloscCzlonkow; i++) {
            KMPCzlonekLista.add(new KMPCzlonek("KMP",rozmiarMapy));
            KMWCzlonekLista.add(new KMWCzlonek("KMW",rozmiarMapy));
        }

        for (KMPCzlonek czlonek : KMPCzlonekLista) {
            System.out.println("Poparcie:" + czlonek.poparcie + " Ochrona:" + czlonek.czyChroniony + " x:" + czlonek.positionX + " y:" + czlonek.positionY);
        }

        for (KMPCzlonek czlonek : KMPCzlonekLista) {
            if ((int)(Math.random()*100+0) <= 50) {
                czlonek.czyChroniony = true;
            }
        }

        System.out.println("\n");

        for (KMPCzlonek czlonek : KMPCzlonekLista) {
            System.out.println("Poparcie:" + czlonek.poparcie + " Ochrona:" + czlonek.czyChroniony + " x:" + czlonek.positionX + " y:" + czlonek.positionY);
        }
    }
}

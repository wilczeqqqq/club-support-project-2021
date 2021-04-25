package pl.dowhankuniewski;

import pl.dowhankuniewski.czlonkowie.KMPCzlonek;
import pl.dowhankuniewski.czlonkowie.KMWCzlonek;

import java.util.ArrayList;
import java.util.List;


public class Symulacja {
    public static void main(String[] args){
        List<KMPCzlonek> KMPCzlonekLista = new ArrayList<>();
        List<KMWCzlonek> KMWCzlonekLista = new ArrayList<>();

        for(int i = 0; i < 50; i++) {
            KMPCzlonekLista.add(new KMPCzlonek("KMP",100));
            KMWCzlonekLista.add(new KMWCzlonek("KMW",100));
        }

        for (KMPCzlonek czlonek : KMPCzlonekLista) {
            System.out.println("Poparcie:" + czlonek.poparcie + " Ochrona:" + czlonek.czyChroniony + " x:" + czlonek.positionX + " y:" + czlonek.positionY);
        }

        for (KMPCzlonek czlonek : KMPCzlonekLista) {
            if ((int)(Math.random()*100+0) <= 50) {
                czlonek.czyChroniony = true;
            }
        }

        for (KMPCzlonek czlonek : KMPCzlonekLista) {
            System.out.println("Poparcie:" + czlonek.poparcie + " Ochrona:" + czlonek.czyChroniony + " x:" + czlonek.positionX + " y:" + czlonek.positionY);
        }
    }
}

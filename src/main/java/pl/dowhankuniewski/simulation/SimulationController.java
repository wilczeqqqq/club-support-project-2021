package pl.dowhankuniewski.simulation;

import lombok.AllArgsConstructor;
import pl.dowhankuniewski.entities.Member;
import pl.dowhankuniewski.entities.SpecialField;
import pl.dowhankuniewski.map.SimulationMap;

import java.util.List;

/**
 * Klasa 'Symulacja' reprezentująca proces symulacyjny całego programu.
 * @author Filip Dowhan, Jakub Kuniewski
 * @version 1.1.0 - 02.08.2022
 */
@AllArgsConstructor
public class SimulationController {
    private final SimulationMap simulationMap;
    private final List<Member> memberList;
    private final List<SpecialField> specialFieldList;
    public final int maxIter;

    /**
     * Wykonuje ruch o ilość jednostek równą nadanej prędkości.
     * Sprawdza, czy obiekt nie wyszedł poza granice mapy.
     * Jeśli obiekt potencjalnie wyszedł poza granice, wykonuje ruch przeciwny.
     */
    public void wykonajRuch() {
        for (Member czlonek : memberList) {
            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionX(czlonek.getPositionX() + czlonek.getSpeed());
                if (czlonek.getPositionX() > simulationMap.getRozmiarMapy()) {
                    czlonek.setPositionX(czlonek.getPositionX() - czlonek.getSpeed());
                }
            }

            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionX(czlonek.getPositionX() - czlonek.getSpeed());
                if (czlonek.getPositionX() > simulationMap.getRozmiarMapy()) {
                    czlonek.setPositionX(czlonek.getPositionX() + czlonek.getSpeed());
                }
            }

            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionY(czlonek.getPositionY() + czlonek.getSpeed());
                if (czlonek.getPositionY() > simulationMap.getRozmiarMapy()) {
                    czlonek.setPositionY(czlonek.getPositionX() - czlonek.getSpeed());
                }
            }

            if (((int) (Math.random() * 99 + 1)) > 50) {
                czlonek.setPositionY(czlonek.getPositionY() - czlonek.getSpeed());
                if (czlonek.getPositionY() > simulationMap.getRozmiarMapy()) {
                    czlonek.setPositionY(czlonek.getPositionX() + czlonek.getSpeed());
                }
            }
        }
    }

    /**
     * Obsługuje spotkania obiektów na tym samym polu.
     * Przeprowadza dialog kończący się zmianą poglądów lub brakiem zmiany.
     */
    public void sprawdzSpotkanieCzlonkow() {
        int KMP=0, KMW=0;
        for (Member czlonekLicznik : memberList) {
            if (czlonekLicznik.getClubChoice().equals("KMP")) {
                KMP++;
            } else {
                KMW++;
            }
        }

        for ( Member czlonek : memberList) {
            for (Member czlonek2 : memberList) {
                if (czlonek.getPositionX() == czlonek2.getPositionX() && czlonek.getPositionY() == czlonek2.getPositionY() && !czlonek.getClubChoice().equals(czlonek2.getClubChoice())) {
                    if (!czlonek.isHasFinalChoice()) {
                        if (czlonek.getClubChoice().equals("KMP")) {
                            if (((int)(Math.random()*99+1)) <= (KMW*100/ memberList.size())) {
                                czlonek.setClubChoice("KMW");
                            }
                        } else {
                            if (((int)(Math.random()*99+1)) <= (KMP*100/ memberList.size())) {
                                czlonek.setClubChoice("KMP");
                            }
                        }
                    }

                    if (!czlonek2.isHasFinalChoice()) {
                        if (czlonek2.getClubChoice().equals("KMP")) {
                            if (((int)(Math.random()*99+1)) <= (KMW*100/ memberList.size())) {
                                czlonek2.setClubChoice("KMW");
                            }
                        } else {
                            if (((int)(Math.random()*99+1)) <= (KMP*100/ memberList.size())) {
                                czlonek2.setClubChoice("KMP");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Obsługuje najście obiektów na pole specjalne.
     * Nadaje status chronionego, jeżeli naszedł.
     */
    public void sprawdzWejscieNaPole() {
        for (Member czlonek : memberList) {
            for (SpecialField pole : specialFieldList) {
                if (czlonek.getPositionX() == pole.getPositionX() && czlonek.getPositionY() == pole.getPositionY()) {
                    czlonek.setHasFinalChoice(true);
                }
            }
        }
    }

    /**
     * Sprawdza posiadanie cechy specjalnej przez obiekty.
     * Jeśli posiadają, nadaje odpowiednie stałe wzmocnienia lub osłabienia.
     */
    public void sprawdzCechySpecjalne() {
        for (Member czlonek : memberList) {
            if (czlonek.isHasSpecialTrait()) {
                if (czlonek.getClubChoice().equals("KMP")) {
                    czlonek.setSpeed((int)(czlonek.getSpeed() * 0.5));
                } else {
                    czlonek.setSpeed((int)(czlonek.getSpeed() * 1.5));
                }
            }
        }
    }

    /**
     * Zapisuje logi symulacji w odpowiednim formacie do pliku 'outFile.txt'.
     */
    public void zapisLogowDoPliku() {
        int KMP=0, KMW=0, chronieniKMP=0, chronieniKMW=0, suma;
        for (Member czlonek : memberList) {
            if (czlonek.getClubChoice().equals("KMP")) {
                KMP++;
            } else {
                KMW++;
            }

            if (czlonek.isHasFinalChoice() && czlonek.getClubChoice().equals("KMP")) {
                chronieniKMP++;
            }

            if (czlonek.isHasFinalChoice() && czlonek.getClubChoice().equals("KMW")) {
                chronieniKMW++;
            }
        }

        suma = chronieniKMP + chronieniKMW;

        System.out.println("KMP/Chronieni:" + KMP + "/" + chronieniKMP + " - - - KMW/Chronieni:" + KMW + "/" + chronieniKMW + " - - - Chronieni - suma:" + suma);
    }

    /**
     * Operuje całą symulacją, wywołując odpowiednie metody i sterując ilością iteracji.
     */
    public void startSymulacji(){
        sprawdzCechySpecjalne();
        for(int iter=0; iter<maxIter; iter++) {
            wykonajRuch();
            sprawdzWejscieNaPole();
            sprawdzSpotkanieCzlonkow();
            zapisLogowDoPliku();
        }
    }
}

package pl.dowhankuniewski;

import pl.dowhankuniewski.entities.EntitiesCreator;
import pl.dowhankuniewski.entities.Member;
import pl.dowhankuniewski.entities.SpecialField;
import pl.dowhankuniewski.map.SimulationMap;
import pl.dowhankuniewski.simulation.SimulationController;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj rozmiar mapy w przedziale [10 ; 100]");
        int simulationMapSize;
        for (;;) {
            simulationMapSize = scanner.nextInt();
            if (simulationMapSize > 100 || simulationMapSize < 10) {
                System.out.println("Podano niedozwolony wymiar. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj ilosc czlonkow na klub w przedziale [1 ; " + (simulationMapSize * simulationMapSize)/2 + "]");
        int membersAmount;
        for (;;) {
            membersAmount = scanner.nextInt();
            if (membersAmount > (simulationMapSize * simulationMapSize)/2 || membersAmount < 1) {
                System.out.println("Podano niedozwolona ilosc czlonkow. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj predkosc poruszania sie czlonkow klubow po mapie w przedziale [1 ; " + (simulationMapSize /4) + "]");
        int speed;
        for (;;) {
            speed = scanner.nextInt();
            if (speed < 1 || speed > (simulationMapSize /4)) {
                System.out.println("Podano niedozwolona predkosc. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj ilosc pol specjalnych na mapie w przedziale [0 ; " + simulationMapSize * simulationMapSize + "]");
        int specialFieldsAmount;
        for (;;) {
            specialFieldsAmount = scanner.nextInt();
            if (specialFieldsAmount < 0 || specialFieldsAmount > simulationMapSize * simulationMapSize) {
                System.out.println("Podano niedozwolona ilosc. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }

        System.out.println("Podaj ilosc iteracji symulacji nie mniejsza niz 1");
        int iterations;
        for (;;) {
            iterations = scanner.nextInt();
            if (iterations < 1) {
                System.out.println("Podano niedozwolona ilosc. Sprobuj ponownie.\n");
            } else {
                break;
            }
        }


        SimulationMap simulationMap = new SimulationMap(simulationMapSize);

        List<Member> memberList1 = EntitiesCreator.createMembersList(simulationMap, speed, membersAmount);
        List<SpecialField> specialFieldList1 = EntitiesCreator.createSpecialFieldList(simulationMap, specialFieldsAmount);

        SimulationController symulacja = new SimulationController(simulationMap,memberList1,specialFieldList1,iterations);

        PrintStream plik = new PrintStream("./outFile.txt");
        System.setOut(plik);

        symulacja.startSymulacji();

        System.out.println("END");
    }
}

package pl.dowhankuniewski.entities;

import pl.dowhankuniewski.map.SimulationMap;

import java.util.LinkedList;
import java.util.List;


public class EntitiesCreator {
    public static List<Member> createMembersList(SimulationMap simulationMap, int speed, int amount) {
        List<Member> list = new LinkedList<>();

        for (int i = 0; i< amount; i++) {
            list.add(Member.builder()
                            .clubChoice("KMP")
                            .speed(speed)
                            .simulationMap(simulationMap)
                            .build());
            list.add(Member.builder()
                            .clubChoice("KMW")
                            .speed(speed)
                            .simulationMap(simulationMap)
                            .build());
        }
        return list;
    }

    public static List<SpecialField> createSpecialFieldList(SimulationMap simulationMap, int amount) {
        List<SpecialField> list = new LinkedList<>();

        for (int i = 0; i< amount; i++) {
            list.add(SpecialField.builder()
                            .simulationMap(simulationMap)
                            .build());
        }
        return list;
    }
}

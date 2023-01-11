package pl.dowhankuniewski.entities;

import pl.dowhankuniewski.map.SimulationMap;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class EntitiesCreator {
    public static List<Member> createMembersList(SimulationMap simulationMap, int speed, int amount) {
        List<Member> listKMP = IntStream.range(0, amount)
                .mapToObj(member -> Member.builder()
                        .clubChoice("KMP")
                        .speed(speed)
                        .simulationMap(simulationMap)
                        .build())
                .collect(Collectors.toList());

        List<Member> listKWM = IntStream.range(0, amount)
                .mapToObj(member -> Member.builder()
                        .clubChoice("KWM")
                        .speed(speed)
                        .simulationMap(simulationMap)
                        .build())
                .collect(Collectors.toList());

        return Stream.concat(listKMP.stream(), listKWM.stream()).collect(Collectors.toList());
    }

    public static List<SpecialField> createSpecialFieldList(SimulationMap simulationMap, int amount) {
        return IntStream.range(0, amount)
                        .mapToObj(specialField -> new SpecialField(simulationMap))
                        .collect(Collectors.toList()
                );
    }
}

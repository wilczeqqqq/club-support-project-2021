package pl.dowhankuniewski.entities;

import pl.dowhankuniewski.map.SimulationMap;

public interface IEntity {

    static boolean randomizeSpecialTrait() {
        return ((int)(Math.random() * 99 + 1)) < 34;
    }

    static int randomizePosition(SimulationMap simulationMap) {
        return (int)(Math.random()* simulationMap.getRozmiarMapy());
    }
}

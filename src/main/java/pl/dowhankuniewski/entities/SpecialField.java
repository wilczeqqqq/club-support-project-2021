package pl.dowhankuniewski.entities;

import lombok.Builder;
import pl.dowhankuniewski.map.SimulationMap;

public class SpecialField extends AEntity {

    @Builder
    public SpecialField(SimulationMap simulationMap) {
        super(
                IEntity.randomizePosition(simulationMap),
                IEntity.randomizePosition(simulationMap)
        );
    }
}

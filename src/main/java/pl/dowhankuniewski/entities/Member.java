package pl.dowhankuniewski.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import pl.dowhankuniewski.map.SimulationMap;

@Getter
@Setter
public class Member extends AEntity {
    @NonNull private String clubChoice;
    @NonNull private int speed;
    private boolean hasFinalChoice = false;
    private boolean hasSpecialTrait;

    @Builder
    public Member(SimulationMap simulationMap, @NonNull String clubChoice, @NonNull int speed) {
        super(
                IEntity.randomizePosition(simulationMap),
                IEntity.randomizePosition(simulationMap)
        );
        this.clubChoice = clubChoice;
        this.speed = speed;
        this.hasSpecialTrait = IEntity.randomizeSpecialTrait();
    }
}

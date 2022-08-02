package pl.dowhankuniewski.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class AEntity implements IEntity {

    private int positionX;
    private int positionY;

}
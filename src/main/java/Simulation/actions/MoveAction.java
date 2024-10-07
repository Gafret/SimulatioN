package Simulation.actions;

import Simulation.entities.mobile.base.Creature;
import Simulation.map.Coordinate2D;
import Simulation.map.SimulationMap;

import java.util.List;

public class MoveAction implements Action {

    @Override
    public void execute(SimulationMap map) {
        List<Coordinate2D> animalPositions = map.getAllEntitiesOfType(Creature.class);
        for (Coordinate2D pos : animalPositions) {
            Creature animal = (Creature) map.getEntity(pos);
            if(animal == null)
                continue;
            animal.makeMove(pos, map);
        }
    }
}
